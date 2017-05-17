package java_workshop04;

import java.util.LinkedList;
import java.util.List;

public class NKH_Java_Workshop04_LibraryManagement {
	/** 도서나 잡지를 저장하기 위한 LinkedList */
	LinkedList<NKH_Java_Workshop04_Book> bookList = new LinkedList<NKH_Java_Workshop04_Book>();

	public NKH_Java_Workshop04_LibraryManagement() {
		bookList = new LinkedList<NKH_Java_Workshop04_Book>();
	}

	public int size() {
		return bookList.size();
	}

	private int findBookIndex(String isbn) {
		if (isbn != null) {
			// int size = bookList.size();
			// for (int i = 0; i < size; i++) {
			// NKH_Java_Workshop04_Book book = bookList.get(i);
			// if (isbn.equals(book.getIsbn())) {
			// return i;
			// }
			// }
			int i = 0;
			for (NKH_Java_Workshop04_Book book : bookList) {
				if (isbn.equals(book.getIsbn())) {
					return i;
				}
				i++;
			}
		}
		return -1;
	}

	public void add(NKH_Java_Workshop04_Book book) {
		if (book != null) {
			String isbn = book.getIsbn();
			int index = findBookIndex(isbn);

			if (index == -1) {
				bookList.add(book);
			} else {
				String msg = String.format("isbn %s번은 이미 등록된 isbn입니다.\n", isbn);
				throw new BookException(msg);
			}
		} else {
			throw new BookException("등록할 책 정보를 입력해 주세요.");
		}
	}

	public void update(NKH_Java_Workshop04_Book book) {
		if (book != null) {
			String isbn = book.getIsbn();
			int index = findBookIndex(isbn);
			if (index > -1) {
				bookList.set(index, book);
			} else {
				String msg = String.format("수정할 isbn %s번을 찾을 수 없습니다.\n", isbn);
				throw new BookException(msg);
			}
		}
	}

	public void remove(String isbn) {
		int index = findBookIndex(isbn);
		if (index > -1) {
			bookList.remove(index);
		} else {
			String msg = String.format("삭제할 isbn %s번을 찾을 수 없습니다.\n", isbn);
			throw new BookException(msg);
		}
	}

	public void printAll() {
		for (NKH_Java_Workshop04_Book book : bookList) {
			System.out.println(book);
		}
		// for (int i = 0; i < bookList.size(); i++) {
		// System.out.println(bookList.get(i).toString());
		// }
	}

	public void printBook() {
		for (NKH_Java_Workshop04_Book book : bookList) {
			if (book instanceof NKH_Java_Workshop04_Book && !(book instanceof NKH_Java_Workshop04_Magazine)) {
				System.out.println(book);
			}
		}

		// for (int i = 0; i < bookList.size(); i++) {
		// boolean isBook = bookList.get(i) instanceof NKH_Java_Workshop04_Book;
		// boolean isMagazine = bookList.get(i) instanceof
		// NKH_Java_Workshop04_Magazine;
		// if (isBook && !(isMagazine)) {
		// System.out.println(bookList.get(i));
		// }
		// }
	}

	public void printMagazine() {
		for (NKH_Java_Workshop04_Book book : bookList) {
			if (book instanceof NKH_Java_Workshop04_Magazine) {
				System.out.println(book);
			}
		}

		// for (int i = 0; i < bookList.size(); i++) {
		// boolean isMagazine = bookList.get(i) instanceof
		// NKH_Java_Workshop04_Magazine;
		// if (isMagazine) {
		// System.out.println(bookList.get(i));
		// }
		// }
	}

	public NKH_Java_Workshop04_Book search(String isbn) {
		int index = findBookIndex(isbn);
		if (index > -1) {
			return bookList.get(index);
		} else {
			String msg = String.format("isbn : %s번 책을 찾을 수 없습니다.", isbn);
			throw new BookException(msg);
		}
	}

	public List<NKH_Java_Workshop04_Book> searchAll(NKH_Java_Workshop04_PageBean bean) {
		List<NKH_Java_Workshop04_Book> finds = new LinkedList<NKH_Java_Workshop04_Book>();
		boolean isFind = false;

		if (bean != null) {
			String key = bean.getKey();
			String word = bean.getWord();
			
			if (key == null || word == null) return bookList;
			for (NKH_Java_Workshop04_Book book : bookList) {
				if (key.equals("author") && word.equals(book.getAuthor())) {
					isFind = true;
				} else if (key.equals("title") && word.equals(book.getTitle())) {
					isFind = true;
				} else if (key.equals("publisher") && word.equals(book.getPublisher())) {
					isFind = true;
				}
				if (isFind) {
					isFind = false;
				}
			}
		}
		return finds;

		// int index = bookList.size();
		// LinkedList<NKH_Java_Workshop04_Book> tempList = new
		// LinkedList<NKH_Java_Workshop04_Book>();
		//
		// if (bean != null) {
		// if (bean.getKey().equals("title")) {
		// for (int i = 0; i < index; i++) {
		// if (bean.getWord().equals(bookList.get(i).getTitle())) {
		// tempList.add(bookList.get(i));
		// }
		// }
		// } else if (bean.getKey().equals("author")) {
		// for (int i = 0; i < index; i++) {
		// if (bean.getWord().equals(bookList.get(i).getAuthor())) {
		// tempList.add(bookList.get(i));
		// }
		// }
		// } else if (bean.getKey().equals("publisher")) {
		// for (int i = 0; i < index; i++) {
		// if (bean.getWord().equals(bookList.get(i).getPublisher())) {
		// tempList.add(bookList.get(i));
		// }
		// }
		// }
		//
		// index = tempList.size();
		// NKH_Java_Workshop04_Book[] arr = new
		// NKH_Java_Workshop04_Book[index--];
		// for (int i = index; i >= 0; i--) {
		// arr[index - i] = tempList.get(i);
		// }
		// return arr;
		// } else {
		// return null;
		// }
	}
}
