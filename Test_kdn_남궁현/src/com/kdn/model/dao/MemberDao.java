package com.kdn.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kdn.model.domain.Member;
import com.kdn.model.domain.PageBean;

public interface MemberDao {
	public void add(Connection con, Member member) throws SQLException;
	public void update(Connection con, Member member) throws SQLException;
	public void update(Connection con, String id) throws SQLException;
	public Member search(Connection con, String id) throws SQLException;
	public List<Member> searchAll(Connection con, PageBean bean) throws SQLException;
	public int getCount(Connection con, PageBean bean) throws SQLException;
}
