package com.kdn;

import java.sql.SQLException;
import java.util.List;

import com.kdn.model.domain.Book;
import com.kdn.model.domain.PageBean;
import com.kdn.model.service.BookService;
import com.kdn.model.service.BookServiceImpl;

public class BookTest {

	public static void main(String[] args) throws SQLException {
		 BookService  bookService = new BookServiceImpl();
		 System.out.println("===============================책 정보 등록=======================================");
		 bookService.add(new Book("1111", "java와 객체지향", "김동근", "jaen", "20150301", 15000, "java를 위한 입문서"));
		 bookService.add(new Book("1112", "쉽게 정복하는 DB", "이세준", "jaen", "20150715", 30000, "핵심 oralce DATABASE"));
		 bookService.add(new Book("1113", "servlet와JSP", "김동근", "jaen", "20150301", 15000, "java를 위한 입문서"));
		 bookService.add(new Book("1114", "spring과 mbc", "김영환", "jaen", "20161101", 30000, "경량의 컨테이너, mvc 기반"));
		 try {
		  bookService.add(new Book("1111", "java와 객체지향", "김동근", "jaen", "20150301", 15000, "java를 위한 입문서"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		 System.out.println("===============================책 정보 수정=======================================");
		 bookService.update(new Book("1114", "spring과  web", "김영환", "kdn", "20161101", 30000, "경량의 컨테이너, mvc 기반"));
		 System.out.println(bookService.search("1114"));
		 try{
		 	bookService.update(new Book("1115", "spring과  web", "김영환", "kdn", "20161101", 30000, "경량의 컨테이너, mvc 기반"));
		 } catch (Exception e) {
		 	
				System.out.println(e.getMessage());
			}
		 System.out.println("===============================isbn으로 책 정보 검색===============================");
		 System.out.println(bookService.search("1111"));
		 try {
		 	System.out.println(bookService.search("1115"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		 System.out.println("===============================출판사명으로 책 정보 검색=============================");
		 PageBean bean = new PageBean("publisher", "jaen", 1);
		 List<Book> books1 = bookService.searchAll(bean );
		 for (Book book : books1) {
				System.out.println(book);
			}
		 System.out.printf("jaen에서 출판한 책 개수 : %d\n", bean.getTotal());
		 System.out.println("===============================책 제목으로 책 정보 검색==============================");
		 PageBean bean2 = new PageBean("title", "s", 1);
		 List<Book> books2 = bookService.searchAll(bean2 );
		 for (Book book : books2) {
				System.out.println(book);
			}
		 System.out.printf("jaen에서 출판한 책 개수 : %d\n", bean2.getTotal());
		 System.out.println("===============================책 정보 삭제=======================================");
		 bookService.remove("1113");
		 List<Book> books3 = bookService.searchAll(new PageBean(null, null, 1) );
		 for (Book book : books3) {
				System.out.println(book);
			}
		 try{
		 	bookService.remove("1113");
		 } catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
