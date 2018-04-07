package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.javalec.ex.dbconnector.*;
import com.javalec.ex.dto.Bbs;

public class BbsDAO {

	public int write(String bbsName, String bbsTitle, String bbsContent) {

		int result = 0;

		String sql = "INSERT INTO mvc_board (bbsName, bbsTitle,bbsContent, bbsHit, bbsGroup, bbsStep, bbsIndent) values (?, ?, ?, 0, 0, 0, 0)";

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

		String sql = "SELECT bbsId, bbsName, bbsTitle, bbsContent, bbsDate, bbsHit, bbsGroup, bbsStep, bbsIndent FROM mvc_board ORDER BY bbsGroup DESC, bbsStep ASC";

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
				int bbsGroup = rs.getInt("bbsGroup");
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

	public Bbs contentView(String strId) {

		this.upHit(strId);

		Bbs bbs = null;

		String sql = "SELECT * FROM mvc_board where bbsId = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, Integer.parseInt(strId));

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int bbsId = rs.getInt("bbsId");
				String bbsName = rs.getString("bbsName");
				String bbsTitle = rs.getString("bbsTitle");
				String bbsContent = rs.getString("bbsContent");
				Timestamp bbsDate = rs.getTimestamp("bbsDate");
				int bbsHit = rs.getInt("bbsHit");
				int bbsGroup = rs.getInt("bbsGroup");
				int bbsStep = rs.getInt("bbsStep");
				int bbsIndent = rs.getInt("bbsIndent");

				bbs = new Bbs(bbsId, bbsName, bbsTitle, bbsContent, bbsDate, bbsHit, bbsGroup, bbsStep, bbsIndent);
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
		return bbs;

	}

	public int modify(String bbsId, String bbsName, String bbsTitle, String bbsContent) {

		int result = 0;

		String sql = "UPDATE mvc_baord SET bbsName = ?, bbsTitle =?, bbsContent = ? WHERE bbsId = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bbsName);
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, bbsContent);
			pstmt.setInt(4, Integer.parseInt(bbsId));

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

	public int delete(String bbsId) {

		int result = 0;

		String sql = "DELETE FROM mvc_board WHERE bbsId = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, Integer.parseInt(bbsId));

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

	public Bbs reply_view(String strId) {

		this.upHit(strId);

		Bbs bbs = null;

		String sql = "SELECT * FROM mvc_board WHERE bbsId = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, Integer.parseInt(strId));

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int bbsId = rs.getInt("bbsId");
				String bbsName = rs.getString("bbsName");
				String bbsTitle = rs.getString("bbsTitle");
				String bbsContent = rs.getString("bbsContent");
				Timestamp bbsDate = rs.getTimestamp("bbsDate");
				int bbsHit = rs.getInt("bbsHit");
				int bbsGroup = rs.getInt("bbsGroup");
				int bbsStep = rs.getInt("bbsStep");
				int bbsIndent = rs.getInt("bbsIndent");

				bbs = new Bbs(bbsId, bbsName, bbsTitle, bbsContent, bbsDate, bbsHit, bbsGroup, bbsStep, bbsIndent);
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
		return bbs;

	}

	public int reply(String bbsName, String bbsTitle, String bbsContent, String bbsGroup, String bbsStep,
			String bbsIndent) {

		this.replyShape(bbsGroup, bbsStep);

		int result = 0;

		String sql = "INSERT INTO mvc_board(bbsName, bbsTitle, bbsContent, bbsGruop, bbsStep, bbsIndent) VALUES (?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bbsTitle);
			pstmt.setString(2, bbsContent);
			pstmt.setInt(3, Integer.parseInt(bbsGroup));
			pstmt.setInt(4, Integer.parseInt(bbsStep) + 1);
			pstmt.setInt(5, Integer.parseInt(bbsIndent) + 1);

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

	private int replyShape(String bbsGroup, String bbsStep) {

		int result = 0;

		String sql = "UPDATE mvc_board SET bbsStep = bbsStep + 1 WHERE bbsGroup = ? AND bbsStep > ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, Integer.parseInt(bbsGroup));
			pstmt.setInt(2, Integer.parseInt(bbsStep));

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

	private int upHit(String bbsId) {

		int result = 0;

		String sql = "UPDATE mvc_board SET bbsHit + 1 WHERE bbsId = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bbsId);

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

}
