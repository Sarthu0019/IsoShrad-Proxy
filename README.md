# IsoShard Proxy: A Distributed CP-Mode Transaction Coordinator & SQL Optimizer

IsoShard Proxy is a high-performance database middleware framework designed to enforce strict ACID compliance across horizontally sharded database clusters. By shifting transaction orchestration and query parsing directly into the network layer, the proxy addresses the traditional trade-offs of the CAP theorem—prioritizing strong Consistency (CP-mode) without introducing crippling application-layer I/O bottlenecks.

The project bridges theoretical **Compiler Design principles** (Lexical tokenization, AST generation, and expression rewriting) with **Cloud-Native Systems Engineering** (Asynchronous non-blocking I/O, Two-Phase Commit consensus protocols, and Cross-Shard Join Aggregations).

---

## 🏗️ Architectural Overview

[ Client Applications / TCP Load Balancers ]
                       │
                       ▼ (SQL via Custom Binary Protocol)


 ┌────────────────────────────────────────────────────────────────────────┐
│                        ISOSHARD PROXY LAYER                            │
│                                                                        │
│  ┌─────────────────────────┐        ┌───────────────────────────────┐  │
│  │    Java Netty Server    │───────►│        ANTLR4 Compiler        │  │
│  │ (Reactor EventLoop Loop)│        │   (Lexer / Parser / AST)      │  │
│  └─────────────────────────┘        └───────────────┬───────────────┘  │
│               ▲                                     │                  │
│               │ (State Sync)                        ▼                  │
│  ┌────────────┴────────────┐        ┌───────────────────────────────┐  │
│  │ 2PC Coordinator Engine  │◄───────│  Consistent Hashing Router   │  │
│  │  (DynamoDB Async WAL)   │        │ (Murmur3 / 100 Virtual Nodes) │  │
│  └────────────┬────────────┘        └───────────────┬───────────────┘  │
│               │                                     │                  │
│               ▼                                     ▼                  │
│  ┌─────────────────────────┐        ┌───────────────────────────────┐  │
│  │  Crash Recovery Daemon  │        │  Cross-Shard Join Aggregator  │  │
│  │ (Epoch Stale-State TTL) │        │   (In-Memory Hash Join Loop)  │  │
│  └─────────────────────────┘        └───────────────────────────────┘  │
└───────────────────────┬─────────────────────────────┬──────────────────┘
│                             │
└──────────────┬──────────────┘
│ (Persistent JDBC Links via HikariCP)
▼
┌───────────────────────┼───────────────────────┐
▼                       ▼                       ▼
[RDS Node 1]            [RDS Node 2]            [RDS Node 3]
(PostgreSQL Shard A)    (PostgreSQL Shard B)    (PostgreSQL Shard C)                      



### Key Engine Sub-Systems

* **High-Throughput Network Protocol (Java Netty):** Built on an asynchronous, non-blocking Reactor Pattern utilizing a single `EventLoop` thread group. It features a custom binary stream packet frame codec (4-byte length header, 1-byte command indicator, and raw UTF-8 SQL payloads) combined with a `LengthFieldBasedFrameDecoder` to prevent TCP fragmentation anomalies under peak traffic conditions.
* **SQL Compiler Frontend (ANTLR4):** Formally tokenizes custom SQL dialects into an Abstract Syntax Tree (AST). Includes parser rules for complex nested queries and mutation blocks (`SELECT`, `INSERT INTO`, `UPDATE SET`).
* **Predicate Pushdown & Consistent Hashing:** A custom `SqlVisitor` pattern traverses generated ASTs to isolate targeted routing keys right out of `WHERE` clauses. These keys are hashed using a 32-bit `MurmurHash3` algorithm across **100 virtual nodes per physical shard** on a sorted `TreeMap` hash ring, preventing horizontal data skewing.
* **Distributed Transaction Coordinator (2PC Engine):** Guarantees atomicity across multi-shard write actions using a non-blocking Two-Phase Commit framework. To bypass processing lag, transaction state configurations (`PREPARED`, `COMMITTED`, `ABORTED`) are written using a non-blocking `DynamoDbAsyncClient` chained via Java `CompletableFuture`.
* **Self-Healing Crash Recovery Daemon:** A background initialization thread running synchronously on proxy boot to clear hanging row locks ("phantom locks") caused by unexpected mid-transaction proxy crashes. The daemon enforces a **30-second Stale-State Timeout (TTL)** threshold relative to the WAL generation epoch to safely ignore active in-flight threads.
* **Cross-Shard Hash JOIN Aggregator:** Intercepts complex analytical read queries spanning disjoint physical partitions. The engine executes queries on multiple database shards simultaneously via parallel async workers, builds an internal hash lookup index of the smaller row set, probes it using the secondary stream, and flushes the merged payloads to the client without memory exhaustion.

---

## 📂 Project Blueprint Tree

```text
├── docs/                    # Research and Progress Documentation (.pdf logs)
├── src/
│   ├── main/
│   │   ├── antlr4/          # IsoShardSql.g4 Lexer/Parser Grammar Rules
│   │   └── java/com/isoshard/
│   │       ├── compiler/    # AST Travellers, Predicate Isolation, and Query Wrappers
│   │       ├── network/     # Netty TCP Reactor Engines, Frame Decoders, and Packet Codecs
│   │       ├── router/      # MurmurHash3 Consistent Hashing Ring Layouts (Virtual Nodes)
│   │       └── tx/          # 2PC Coordinator, WAL Logging, and Cross-Shard JOIN Engines
│   └── test/java/com/isoshard/compiler/ # JUnit 5 Differential Syntax Error Verification
├── mvnw.cmd                 # Standalone local Maven compiler environment wrapper
├── pom.xml                  # Central Dependency Management Project Core Descriptor
└── README.md