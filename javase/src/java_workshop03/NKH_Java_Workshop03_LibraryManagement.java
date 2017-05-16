package java_workshop03;

public class NKH_Java_Workshop03_LibraryManagement {
	private NKH_Java_Workshop03_Book[] bookList;
	private int bookIndex;

	public NKH_Java_Workshop03_LibraryManagement() {
		bookList = new NKH_Java_Workshop03_Book[15];
	}

	public int size() {
		return bookIndex;
	}

	private int findBookIndex(String isbn) {
		if (isbn != null) {
			for (int i = 0; i < bookIndex; i++) {
				if (isbn.equals(bookList[i].getIsbn())) {
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

			if (index < 0) {
				int size = bookList.length;

				if (bookIndex == size) {
					NKH_Java_Workshop03_Book[] copy = new NKH_Java_Workshop03_Book[size + 10];
					System.arraycopy(bookList, 0, copy, 0, size);
					bookList = copy;
				}

				bookList[bookIndex++] = book;
			} else {
				System.out.printf("isbn %s번은 이미 등록된 isbn입니다.\n", isbn);
			}
		}
	}

	public void update(NKH_Java_Workshop03_Book book) {
		if (book != null) {
			String isbn = book.getIsbn();
			int index = findBookIndex(isbn);
			if (index > 0) {
				bookList[index] = book;
			} else {
				System.out.printf("수정할 isbn %s번을 찾을 수 없습니다.\n", isbn);
			}
		}
	}

	public void remove(String isbn) {
		int index = findBookIndex(isbn);
		if (index > -1) {
			bookList[index] = bookList[bookIndex - 1];
			bookList[bookIndex-- - 1] = null;
		} else {
			System.out.printf("삭제할 isbn %s번을 찾을 수 없습니다.\n", isbn);
		}
	}

	public void printAll() {
		for (int i = 0; i < bookIndex; i++) {
			System.out.println(bookList[i]);
		}
	}

	public void printBook() {
		for (int i = 0; i < bookIndex; i++) {
			boolean isBook = bookList[i] instanceof NKH_Java_Workshop03_Book;
			boolean isMagazine = bookList[i] instanceof NKH_Java_Workshop03_Magazine;
			if (isBook && !(isMagazine)) {
				System.out.println(bookList[i]);
			}
		}
	}

	public void printMagazine() {
		for (int i = 0; i < bookIndex; i++) {
			boolean isMagazine = bookList[i] instanceof NKH_Java_Workshop03_Magazine;
			if (isMagazine) {
				System.out.println(bookList[i]);
			}
		}
	}

	public NKH_Java_Workshop03_Book search(String isbn) {
		int index = findBookIndex(isbn);
		if (index > -1) {
			return bookList[index];
		} else {
			return null;
		}
	}

	public NKH_Java_Workshop03_Book[] searchAll(NKH_Java_Workshop03_PageBean bean) {
		NKH_Java_Workshop03_Book[] temp = new NKH_Java_Workshop03_Book[bookIndex];
		int index = 0;
		if (bean != null) {
			if (bean.getKey().equals("title")) {
				for (int i = 0; i < bookIndex; i++) {
					if (bean.getWord().equals(bookList[i].getTitle())) {
						temp[index++] = bookList[i];
					}
				}
			} else if (bean.getKey().equals("author")) {
				for (int i = 0; i < bookIndex; i++) {
					if (bean.getWord().equals(bookList[i].getAuthor())) {
						temp[index++] = bookList[i];
					}
				}
			} else if (bean.getKey().equals("publisher")) {
				for (int i = 0; i < bookIndex; i++) {
					if (bean.getWord().equals(bookList[i].getPublisher())) {
						temp[index++] = bookList[i];
					}
				}
			}
			NKH_Java_Workshop03_Book[] arr = new NKH_Java_Workshop03_Book[index--];
			for (int i = index; i >= 0; i--) {
				arr[index-i] = temp[i];
			}
			return arr;
		} else {
			return null;
		}
	}
}
