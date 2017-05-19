package com.kdn.model.service;

import java.util.List;

import com.kdn.model.domain.Book;
import com.kdn.model.domain.PageBean;

public interface BookService {
	public void add(Book book);
	public void update(Book book);
	public void remove(String isbn);
	public Book search(String isbn);
	public List<Book> searchAll(PageBean bean);
}
