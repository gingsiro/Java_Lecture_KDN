package com.kdn.model.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kdn.model.dao.BookDao;
import com.kdn.model.dao.BookDaoImpl;
import com.kdn.model.domain.Book;
import com.kdn.model.domain.BookException;
import com.kdn.model.domain.PageBean;
import com.kdn.util.DBUtil;

public class BookServiceImpl implements BookService {
	BookDao dao = new BookDaoImpl();

	@Override
	public void add(Book book) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Book result = dao.search(con, book.getIsbn());
			if(result == null){
				dao.add(con, book);
			} else {
				throw new BookException(String.format("%s 번 책은 이미 있습니다.",book.getIsbn()));
			}
			
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new BookException("생성 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
		
	}

	@Override
	public void update(Book book) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Book result = dao.search(con, book.getIsbn());
			if(result != null){
				dao.update(con, book);
			} else {
				throw new BookException(String.format("%s 번 책은 없는 책입니다.", book.getIsbn()));
			}
			
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new BookException("수정 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public void remove(String isbn) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Book result = dao.search(con, isbn);
			if(result != null){
				dao.remove(con, isbn);
			} else {
				throw new BookException(String.format("%s 번 책은 없는 책입니다.", isbn));
			}
			
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new BookException("삭제 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public Book search(String isbn) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Book find = dao.search(con, isbn);
			
			return find;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookException("검색 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public List<Book> searchAll(PageBean bean) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			ArrayList<Book> books = new ArrayList<Book>();
			books.addAll(dao.searchAll(con, bean));
			
			return books;
			
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new BookException("검색 중 오류 발생");
		} finally {
			
			DBUtil.close(con);
		}
	}

}
