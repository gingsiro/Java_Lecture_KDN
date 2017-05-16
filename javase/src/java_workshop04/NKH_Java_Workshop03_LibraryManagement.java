package java_workshop04;

import java.util.LinkedList;
import java.util.ListResourceBundle;

public class NKH_Java_Workshop03_LibraryManagement {
	/** 도서나 잡지를 저장하기 위한 LinkedList */
	LinkedList<NKH_Java_Workshop03_Book> bookList = new LinkedList<NKH_Java_Workshop03_Book>();
	
	public NKH_Java_Workshop03_LibraryManagement() {
		bookList = new LinkedList<NKH_Java_Workshop03_Book>();
	}

	public int size() {
		return bookList.size();
	}

	private int findBookIndex(String isbn) {
		if (isbn != null) {
			int size = bookList.size();
			for (int i = 0; i < size; i++) {
				NKH_Java_Workshop03_Book book = bookList.get(i);
				if (isbn.equals(book.getIsbn())) {
					return i;
				}
			}
		}
		return -1;
	}

	public void add(NKH_Java_Workshop03_Book book) {
		if (book != null) {
			String isbn = book.getIsbn();
			int index = findBookIndex(isbn);

			if (index == -1) {
				bookList.add(book);
			} else {
				System.out.printf("isbn %s번은 이미 등록된 isbn입니다.\n", isbn);
			}
		}
	}

	public void update(NKH_Java_Workshop03_Book book) {
		if (book != null) {
			String isbn = book.getIsbn();
			int index = findBookIndex(isbn);
			if (index > -1) {
				bookList.set(index, book);
			} else {
				System.out.printf("수정할 isbn %s번을 찾을 수 없습니다.\n", isbn);
			}
		}
	}

	public void remove(String isbn) {
		int index = findBookIndex(isbn);
		if (index > -1) {
			bookList.remove(index);
		} else {
			System.out.printf("삭제할 isbn %s번을 찾을 수 없습니다.\n", isbn);
		}
	}

	public void printAll() {
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i).toString());
		}
	}

	public void printBook() {
		for (int i = 0; i < bookList.size(); i++) {
			boolean isBook = bookList.get(i) instanceof NKH_Java_Workshop03_Book;
			boolean isMagazine = bookList.get(i) instanceof NKH_Java_Workshop03_Magazine;
			if (isBook && !(isMagazine)) {
				System.out.println(bookList.get(i));
			}
		}
	}

	public void printMagazine() {
		for (int i = 0; i < bookList.size(); i++) {
			boolean isMagazine = bookList.get(i) instanceof NKH_Java_Workshop03_Magazine;
			if (isMagazine) {
				System.out.println(bookList.get(i));
			}
		}
	}

	public NKH_Java_Workshop03_Book search(String isbn) {
		int index = findBookIndex(isbn);
		if (index > -1) {
			return bookList.get(index);
		} else {
			return null;
		}
	}

	public NKH_Java_Workshop03_Book[] searchAll(NKH_Java_Workshop03_PageBean bean) {
		int index = bookList.size();
		LinkedList<NKH_Java_Workshop03_Book> tempList = new LinkedList<NKH_Java_Workshop03_Book>();
				
		if (bean != null) {
			if (bean.getKey().equals("title")) {
				for (int i = 0; i < index; i++) {
					if (bean.getWord().equals(bookList.get(i).getTitle())) {
						tempList.add(bookList.get(i));
					}
				}
			} else if (bean.getKey().equals("author")) {
				for (int i = 0; i < index; i++) {
					if (bean.getWord().equals(bookList.get(i).getAuthor())) {
						tempList.add(bookList.get(i));
					}
				}
			} else if (bean.getKey().equals("publisher")) {
				for (int i = 0; i < index; i++) {
					if (bean.getWord().equals(bookList.get(i).getPublisher())) {
						tempList.add(bookList.get(i));
					}
				}
			}
			
			index = tempList.size();
			NKH_Java_Workshop03_Book[] arr = new NKH_Java_Workshop03_Book[index--];
			for (int i = index; i >= 0; i--) {
				arr[index-i] = tempList.get(i);
			}
			return arr;
		} else {
			return null;
		}
	}
}
