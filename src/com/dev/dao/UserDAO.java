package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dev.db.DBManager;
import com.dev.dto.UserDTO;

public class UserDAO {
	private DataSource dataSource;

	public UserDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UserDTO select(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		UserDTO uDTO = null;
	
		try {
			conn = dataSource.getConnection();
			String sql ="SELECT * from user WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int seq = rs.getInt("seq");
				String password = rs.getString("password");
				String name = rs.getString("name");
				int gender = rs.getInt("gender");
				String salt = rs.getString("salt");
				uDTO = new UserDTO(seq, id, password, name ,gender, salt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		
		return uDTO;
	}
	public boolean registerUser(String id, String password, String name, int gender) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =0;

		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO user(id,password,name,gender) VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setInt(4, gender);
			result = pstmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch(Exception e2){
				e2.printStackTrace();
			}
		}

		if(result==0) {
			System.out.println("회원가입 실패");
			return false;
		} else {
			System.out.println("회원가입 성공");
			return true;
		}
	}
}
