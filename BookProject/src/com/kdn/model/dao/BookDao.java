package com.kdn.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kdn.model.domain.Book;
import com.kdn.model.domain.PageBean;

public interface BookDao{
	public void add(Connection con, Book book) throws SQLException;
	public void update(Connection con, Book book) throws SQLException;
	public void remove(Connection con, String isbn) throws SQLException;
	public Book search(Connection con, String isbn) throws SQLException;
	public List<Book> searchAll(Connection con, PageBean bean) throws SQLException;
	public int getCount(Connection con, PageBean bean) throws SQLException;
}
