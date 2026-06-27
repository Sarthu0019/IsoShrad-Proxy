package com.isoshrad.network;

import java.nio.charset.StandardCharsets;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class IsoShardPacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        // Wait until we have at least the 4-byte header (payload length)
        if (in.readableBytes() < 4) {
            return;
        }
        
        in.markReaderIndex();
        int payloadLength = in.readInt();
        
        // Wait until the entire payload has arrived (handles TCP fragmentation)
        if (in.readableBytes() < payloadLength) {
            in.resetReaderIndex();
            return;
        }
        
        // Read the 1-byte command type (e.g., 0x01 for QUERY, 0x02 for PREPARE)
        byte commandType = in.readByte();
        
        // Read the actual SQL string payload
        CharSequence sqlQuery = in.readCharSequence(payloadLength - 1, StandardCharsets.UTF_8);
        
        // Pass the decoded query object down the pipeline to the AST Compiler
        out.add(new IsoShardRequest(commandType, sqlQuery.toString()));
    }
}