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
	DBManager dbManager;
	
	public UserDAO() {
		dbManager = new DBManager();
	}
	
	public UserDTO select(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		UserDTO uDTO = null;
	
		try {
			conn = dbManager.getConnection();
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
			dbManager.close(rs, pstmt, conn);
		}
		
		return uDTO;
	}
	public int registerUser(String id, String password, String name, int gender) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =0;

		try {
			conn = dbManager.getConnection();
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
			dbManager.close(pstmt, conn);
		}

		return result;
	}
}
