// Generated from IsoShardSql.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IsoShardSqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IsoShardSqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(IsoShardSqlParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(IsoShardSqlParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(IsoShardSqlParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(IsoShardSqlParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnList(IsoShardSqlParser.ColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#valueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueList(IsoShardSqlParser.ValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#assignmentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentList(IsoShardSqlParser.AssignmentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(IsoShardSqlParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(IsoShardSqlParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(IsoShardSqlParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsoShardSqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(IsoShardSqlParser.ExpressionContext ctx);
}