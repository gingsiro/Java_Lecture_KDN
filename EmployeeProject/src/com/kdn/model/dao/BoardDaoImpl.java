package com.kdn.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kdn.model.domain.Board;
import com.kdn.model.domain.FileBean;
import com.kdn.model.domain.PageBean;
import com.kdn.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	@Override
	public void add(Connection con, Board board) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " insert into board(no, id, title, regdate, contents) "
					+ " values(board_no.nextval, ?, ?, sysdate, ?) ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, board.getId());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getContents());

			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public void update(Connection con, Board board) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " update board set id=?, title=?, regdate=sysdate, contents=? " + " where no=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, board.getId());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getContents());
			stmt.setInt(4, board.getNo());

			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public void remove(Connection con, int no) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " delete from board where no=? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, no);

			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public Board search(Connection con, int no) throws SQLException {
		return null;
	}

	@Override
	public List<Board> searchAll(Connection con, PageBean bean) throws SQLException {
		return null;
	}

	@Override
	public int getCount(Connection con, PageBean bean) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String key = bean.getKey();
			String word = bean.getWord();
			StringBuilder sql = new StringBuilder(100);

			sql.append(" select count(*) cnt from board where 1=1 ");
			if (key != null & word != null 
					&& !key.equals("all") 
					&& word.trim().equals("")) {
				if (key.equals("id")) {
					sql.append(" and id=? \n");
				} else if(key.equals("title")) {
					sql.append(" and title= '%'||?||'%' \n");
				} else if(key.equals("contents")){
					sql.append(" and contents= '%'||?||'%' \n");					
				}
				stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, word);
				rs = stmt.executeQuery();
			} else {
				stmt = con.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
			}
			
			if(rs.next()){
				return rs.getInt("cnt");
			}

		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return 1;
		
		// PreparedStatement stmt = null;
		// ResultSet rs = null;
		// try {
		// //id, title, contents
		// String key= bean.getKey();
		// String word = bean.getWord();
		// StringBuilder sql = new StringBuilder(100);
		//
		// sql.append(" select count(*) cnt from board where 1=1 ");
		// if(key != null && !key.equals("all") && word != null &&
		// word.trim().equals("")){
		// if (key.equals("id")) {
		// sql.append(" and id=? \n");
		// }else if(key.equals("title")) {
		// sql.append(" and title like '%'||?||'%' \n");
		// }else if(key.equals("contents")) {
		// sql.append(" and contents like '%'||?||'%' \n");
		// }
		// }
		//
		// stmt = con.prepareStatement(sql.toString());
		// if(key != null && !key.equals("all") && word != null &&
		// word.trim().equals("")){
		// stmt.setString(1, word);
		// }
		//
		// rs = stmt.executeQuery();
		// if(rs.next()){
		// return rs.getInt("cnt");
		// }
		// } finally {
		// DBUtil.close(rs);
		// DBUtil.close(stmt);
		// }
		// return 0;
	}

	@Override
	public int getBoardNo(Connection con) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = " select board_no.nextval from dual ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return 0;
	}

	@Override
	public void addFiles(Connection con, List<FileBean> files, int bno) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " insert into boardfile(no, rfilename, sfilename, bno) "
					+ " values(boardfile_no.nextval, ?, ?, ?) ";
			stmt = con.prepareStatement(sql);
			for (FileBean fileBean : files) {
				stmt.setInt(1, fileBean.getNo());
				stmt.setString(2, fileBean.getRfilename());
				stmt.setString(3, fileBean.getSfilename());
				stmt.addBatch(); // 여러 배열처럼 쿼리 추가하기
			}

			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public void removeFiles(Connection con, int bno) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " delete from boardfile where bno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, bno);

			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}
}
