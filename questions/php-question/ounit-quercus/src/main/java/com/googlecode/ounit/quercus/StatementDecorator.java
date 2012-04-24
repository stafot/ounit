package com.googlecode.ounit.quercus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

/**
 * A statement decorator that filters out stupid
 * "SET NAMES" statements generated by Quercus
 * 
 * @author anttix
 *
 */
public class StatementDecorator implements Statement {
	Statement statement;
	
	public StatementDecorator(Statement statement) {
		this.statement = statement;
	}

	@Override
	public void addBatch(String sql) throws SQLException {
		statement.addBatch(sql);
	}

	@Override
	public void cancel() throws SQLException {
		statement.cancel();
	}

	@Override
	public void clearBatch() throws SQLException {
		statement.clearBatch();
	}

	@Override
	public void clearWarnings() throws SQLException {
		statement.clearWarnings();
	}

	@Override
	public void close() throws SQLException {
		statement.close();
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys)
			throws SQLException {
		return statement.execute(sql, autoGeneratedKeys);
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		return statement.execute(sql, columnIndexes);
	}

	@Override
	public boolean execute(String sql, String[] columnNames)
			throws SQLException {
		return statement.execute(sql, columnNames);
	}

	@Override
	public boolean execute(String sql) throws SQLException {
		return statement.execute(sql);
	}

	@Override
	public int[] executeBatch() throws SQLException {
		return statement.executeBatch();
	}

	@Override
	public ResultSet executeQuery(String sql) throws SQLException {
		return statement.executeQuery(sql);
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException {
		return statement.executeUpdate(sql, autoGeneratedKeys);
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException {
		return statement.executeUpdate(sql, columnIndexes);
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames)
			throws SQLException {
		return statement.executeUpdate(sql, columnNames);
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		if(sql.startsWith("SET NAMES") || sql.startsWith("SET CHARACTER"))
			return 0;
		else
			return statement.executeUpdate(sql);
	}

	@Override
	public Connection getConnection() throws SQLException {
		return statement.getConnection();
	}

	@Override
	public int getFetchDirection() throws SQLException {
		return statement.getFetchDirection();
	}

	@Override
	public int getFetchSize() throws SQLException {
		return statement.getFetchSize();
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		return statement.getGeneratedKeys();
	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		return statement.getMaxFieldSize();
	}

	@Override
	public int getMaxRows() throws SQLException {
		return statement.getMaxRows();
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		return statement.getMoreResults();
	}

	@Override
	public boolean getMoreResults(int current) throws SQLException {
		return statement.getMoreResults(current);
	}

	@Override
	public int getQueryTimeout() throws SQLException {
		return statement.getQueryTimeout();
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		return statement.getResultSet();
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		return statement.getResultSetConcurrency();
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		return statement.getResultSetHoldability();
	}

	@Override
	public int getResultSetType() throws SQLException {
		return statement.getResultSetType();
	}

	@Override
	public int getUpdateCount() throws SQLException {
		return statement.getUpdateCount();
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return statement.getWarnings();
	}

	@Override
	public boolean isClosed() throws SQLException {
		return statement.isClosed();
	}

	@Override
	public boolean isPoolable() throws SQLException {
		return statement.isPoolable();
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return statement.isWrapperFor(iface);
	}

	@Override
	public void setCursorName(String name) throws SQLException {
		statement.setCursorName(name);
	}

	@Override
	public void setEscapeProcessing(boolean enable) throws SQLException {
		statement.setEscapeProcessing(enable);
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		statement.setFetchDirection(direction);
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		statement.setFetchSize(rows);
	}

	@Override
	public void setMaxFieldSize(int max) throws SQLException {
		statement.setMaxFieldSize(max);
	}

	@Override
	public void setMaxRows(int max) throws SQLException {
		statement.setMaxRows(max);
	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException {
		statement.setPoolable(poolable);
	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException {
		statement.setQueryTimeout(seconds);
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return statement.unwrap(iface);
	}
}
