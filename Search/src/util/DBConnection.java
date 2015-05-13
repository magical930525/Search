package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private Connection conn;
	private Statement stmt;
	
	/**
		打开数据库
	*/
	public void open() 
	{
		try 
		{
			//Class.forName("sun.jdbc.odbc.jdbcodbcdriver");
			Class.forName("com.mysql.jdbc.Driver");   //加载数据库驱动 //JDBC连接方式        
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/search","root","123");
			//conn = DriverManager.getConnection("jdbc:odbc:aaa");
				stmt=conn.createStatement();
			System.out.println("打开数据库连接");
		} catch (Exception ex)  {
			System.err.println("打开数据库时出错: " + ex.getMessage());
		}
	}

	
	/**
		关闭数据库，将连接返还给连接池
	*/
	public void close() 
	{
		try 
		{
		
				
		//	connMgr.freeConnection("java", conn);
			conn.close();
			System.out.println ("释放连接");
		} 
		catch (SQLException ex) 
		{
			System.err.println("返还连接池出错: " + ex.getMessage());
		}
	}

	/**
		执行查询
	*/
	public ResultSet executeQuery(String sql) throws SQLException
	{
		ResultSet rs = null;
		

		rs = stmt.executeQuery(sql);
		System.out.println ("执行查询");
		return rs;
	}

	/**
		执行增删改
	*/
	public int executeUpdate(String sql) throws SQLException
	{
		int ret = 0;
		
	
		ret = stmt.executeUpdate(sql);
	
		System.out.println ("执行增删改");
		return ret;
	}

	/**
		将SQL语句加入到批处理
	*/
	public void addBatch(String sql) throws SQLException 
	{
		stmt.addBatch(sql);
	}

	/**
		执行批处理
	*/
	public int [] executeBatch() throws SQLException 
	{
		boolean isAuto=conn.getAutoCommit();
		
		conn.setAutoCommit(false);
		int [] updateCounts = stmt.executeBatch();
		
//		conn.commit();
		
//		conn.setAutoCommit(isAuto);
		//conn.setAutoCommit(true);
		return updateCounts;
	}
	public boolean getAutoCommit() throws SQLException
	{
		return conn.getAutoCommit();
	}
	public void setAutoCommit(boolean auto)  throws SQLException 
	{
		conn.setAutoCommit(auto);
	}
	
	public void commit() throws SQLException 
	{
		conn.commit();
//		this.close();
	}
	public void rollBack() throws SQLException 
	{
		conn.rollback();
//		this.close();
	}
}
