package com.kdn.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kdn.model.domain.Member;
import com.kdn.model.domain.PageBean;
import com.kdn.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	@Override
	public void add(Connection con, Member member) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " insert into member(id, password, name, email, address) "
					   + " values(?, ?, ?, ?, ?) ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getEmail());
			stmt.setString(5, member.getAddress());
			stmt.executeUpdate();

		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public void update(Connection con, Member member) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " update member set password=?, name=?, email=?, address=? "
					   + " where id=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getPassword());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getEmail());
			stmt.setString(4, member.getAddress());
			stmt.setString(5, member.getId());

			stmt.executeUpdate();

		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public void update(Connection con, String id) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " update member set withdraw=? "
					   + " where id=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "Y");
			stmt.setString(2, id);

			stmt.executeUpdate();

		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public Member search(Connection con, String id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = " select * from member where id=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);

			rs = stmt.executeQuery();
			if (rs.next()) {
				return new Member(rs.getString("id")
								, rs.getString("password")
								, rs.getString("name")
								, rs.getString("email")
								, rs.getString("email")
								, rs.getString("withdraw")
								);
			}
			return null;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
	}

	@Override
	public List<Member> searchAll(Connection con, PageBean bean) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Member> lists = new ArrayList<Member>();
		try {
			String key = bean.getKey();
			String word = bean.getWord();
			StringBuilder sql = new StringBuilder(200);
			sql.append(" select * from member where 1=1 ");
			if (key != null && word != null && !key.equals("all") && !word.equals("")) {
				if (key.equals("id")) {
					sql.append(" and id=? ");
				} else if (key.equals("name")) {
					sql.append(" and name=? ");
				} else if (key.equals("address")) {
					sql.append(" and address=?");
				}
				stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, word);
				rs = stmt.executeQuery();

			} else {
				stmt = con.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
			}

			while (rs.next()) {
				lists.add(new Member(rs.getString("id")
								   , rs.getString("password")
								   , rs.getString("name")
								   , rs.getString("email")
								   , rs.getString("email")
								   , rs.getString("withdraw")
								   ));
			}
			return lists;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
	}

	@Override
	public int getCount(Connection con, PageBean bean) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String key = bean.getKey();
			String word = bean.getWord();
			StringBuilder sql = new StringBuilder(200);
			sql.append(" select count(*) from member where 1=1 ");
			if (key != null && word != null && !key.equals("all") && !word.equals("")) {
				if (key.equals("id")) {
					sql.append(" and id=? ");
				} else if (key.equals("name")) {
					sql.append(" and name=? ");
				} else if (key.equals("address")) {
					sql.append(" and address=?");
				}
				stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, word);
				rs = stmt.executeQuery();

			} else {
				stmt = con.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
			}

			if (rs.next()) {
				return rs.getInt("cnt");
			}
			return 0;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
	}

}
