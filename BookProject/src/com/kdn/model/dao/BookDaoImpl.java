package com.kdn.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kdn.model.domain.Book;
import com.kdn.model.domain.PageBean;
import com.kdn.util.DBUtil;

public class BookDaoImpl implements BookDao {

	@Override
	public void add(Connection con, Book book) throws SQLException {
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into book(isbn, title, author, publisher, pubdate, price, info) "
					+ " values(?, ?, ?, ?, ?, ?, ?) ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, book.getIsbn());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getAuthor());
			stmt.setString(4, book.getPublisher());
			stmt.setString(5, book.getPubDate());
			stmt.setInt(6, book.getPrice());
			stmt.setString(7, book.getInfo());

			stmt.executeUpdate();

		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public void update(Connection con, Book book) throws SQLException {
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update book set title=?, author=?, publisher=?, pubdate=?, price=?, info=?"
					+ " where isbn=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getPublisher());
			stmt.setString(4, book.getPubDate());
			stmt.setInt(5, book.getPrice());
			stmt.setString(6, book.getInfo());
			stmt.setString(7, book.getIsbn());

			stmt.executeUpdate();

		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public void remove(Connection con, String isbn) throws SQLException {
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete book where isbn=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, isbn);

			stmt.executeUpdate();

		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public Book search(Connection con, String isbn) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from book " + " where isbn=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, isbn);

			rs = stmt.executeQuery();

			if (rs.next()) {
				return new Book(rs.getString("isbn")
							  , rs.getString("title")
							  , rs.getString("author")
							  ,	rs.getString("publisher")
							  , rs.getString("pubdate")
							  , rs.getInt("price")
							  , rs.getString("info")
							  );
			}
			return null;

		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
	}

	@Override
	public List<Book> searchAll(Connection con, PageBean bean) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			con = DBUtil.getConnection();
			String key = bean.getKey();
			String word = bean.getWord();
			StringBuilder sql = new StringBuilder(100);
			sql.append(" select * from book " + " where 1=1 ");
			
			if(key!=null && word!=null
					&&!key.equals("all")
					&&!word.equals("")){
				if(key.equals("isbn")){
					sql.append(" and isbn=? ");
				} else if(key.equals("title")){
					sql.append(" and title like '%'||?||'%' ");
				} else if(key.equals("author")){
					sql.append(" and author=? ");
				} else if(key.equals("publisher")){
					sql.append(" and publisher=? ");
				} else if(key.equals("info")){
					sql.append(" and info like '%'||?||'%' ");
				}

				stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, word);
				rs = stmt.executeQuery();
			} else{
				stmt = con.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
			}
			

			while (rs.next()) {
				books.add(new Book(rs.getString("isbn")
						  		 , rs.getString("title")
						  		 , rs.getString("author")
						  		 ,	rs.getString("publisher")
						  		 , rs.getString("pubdate")
						  		 , rs.getInt("price")
						  		 , rs.getString("info")
						  		 ));
			}
			return books;

		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
	}

	@Override
	public int getCount(Connection con, PageBean bean) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			con = DBUtil.getConnection();
			String key = bean.getKey();
			String word = bean.getWord();
			StringBuilder sql = new StringBuilder(100);
			sql.append(" select count(*) cnt from book " + " where 1=1 ");
			
			if(key!=null && word!=null
					&&!key.equals("all")
					&&!word.equals("")){
				if(key.equals("isbn")){
					sql.append(" and isbn=? ");
				} else if(key.equals("title")){
					sql.append(" and title like '%'||?||'%' ");
				} else if(key.equals("author")){
					sql.append(" and author=? ");
				} else if(key.equals("publisher")){
					sql.append(" and publisher=? ");
				} else if(key.equals("info")){
					sql.append(" and info like '%'||?||'%' ");
				}

				stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, word);
				rs = stmt.executeQuery();
			} else{
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
