package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dev.db.DBManager;
import com.dev.dto.BoardDTO;
import com.dev.dto.BoardListDTO;
import com.dev.dto.UserDTO;

public class BoardDAO {
	private DataSource dataSource;

	public BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(int userSeq, String title, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO board(user_seq, title, content, registered_at) VALUES(?,?,?,NOW())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userSeq);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}
	
	public ArrayList<BoardListDTO> list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardListDTO> list = new ArrayList<BoardListDTO>();
		
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT board.seq, title, content, id, registered_at, hit FROM board INNER JOIN user ON board.user_seq = user.seq";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bSeq = rs.getInt("board.seq");
				String bTitle = rs.getString("title");
				String bContent = rs.getString("content");
				String uId = rs.getString("id");
				String registered_at = rs.getString("registered_at");
				int bHit = rs.getInt("hit");
				
				BoardListDTO boardListDTO = new BoardListDTO(bSeq,bTitle,bContent, uId, registered_at, bHit);
				list.add(boardListDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public BoardListDTO select(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		BoardListDTO dto= null;
		try {
			conn = dataSource.getConnection();
			String sql ="SELECT board.seq, title, content, id, registered_at, hit FROM board INNER JOIN user ON board.user_seq = user.seq WHERE board.seq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				int bSeq = rs.getInt("board.seq");
				String bTitle = rs.getString("title");
				String uId = rs.getString("id");
				String bContent = rs.getString("content");
				String registered_at = rs.getString("registered_at");
				int bHit = rs.getInt("hit");
				
				dto = new BoardListDTO(bSeq,bTitle,bContent, uId, registered_at, bHit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	public void hitUp(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql ="UPDATE board SET hit=hit+1 WHERE seq =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			int result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}

	public void update(int seq, String uId, String title, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql ="UPDATE board SET title=?, content=? WHERE seq =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, seq);
			int result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}

	public void delete(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql ="DELETE FROM board WHERE seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			int result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		
	}
}
