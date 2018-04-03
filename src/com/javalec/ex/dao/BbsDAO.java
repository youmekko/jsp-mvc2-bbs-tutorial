package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.javalec.ex.dbconnector.DBConnection;
import com.javalec.ex.dto.Bbs;

public class BbsDAO {

	public int write(String bbsName, String bbsTitle, String bbsContent) {

		int result = 0;

		String sql = "INSERT INTO mvc_board (bbsId, bbsName, bbsTitle,bbsContent, bbsHit, bbsGroup, bbsStep, bbsIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bbsName);
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, bbsContent);

			result = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;

	}

	public ArrayList<Bbs> list() {

		ArrayList<Bbs> bbss = new ArrayList<>();

		String sql = "SLECT bbsId, bbsName, bbsTitle, bbsContent, bbsDate, bbsHit, bbsGroup, bbsStep, bbsIndent FROM mvc_board ORDER BY bbsGroup DESC, bbsStep ASC";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int bbsId = rs.getInt("bbsId");
				String bbsName = rs.getString("bbsName");
				String bbsTitle = rs.getString("bbsTitle");
				String bbsContent = rs.getString("bbsContent");
				Timestamp bbsDate = rs.getTimestamp("bbsDate");
				int bbsHit = rs.getInt("bbsHit");
				int bbsGroup = rs.getInt("bbbGroup");
				int bbsStep = rs.getInt("bbsStep");
				int bbsIndent = rs.getInt("bbsIndent");

				Bbs bbs = new Bbs(bbsId, bbsName, bbsTitle, bbsContent, bbsDate, bbsHit, bbsGroup, bbsStep, bbsIndent);
				bbss.add(bbs);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return bbss;
	}

	public Bbs contentView(String bbsId) {
		// TODO Auto-generated method stub
		return null;
	}

}
