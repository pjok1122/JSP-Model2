package com.dev.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	DataSource dataSource;
	
	public DBManager() {
		Context context;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void close(PreparedStatement pstmt, Connection conn) {
		try{
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
