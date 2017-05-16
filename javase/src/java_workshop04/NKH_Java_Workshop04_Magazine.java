package java_workshop04;

public class NKH_Java_Workshop04_Magazine extends NKH_Java_Workshop04_Book {
	private int year;
	private int month;

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		if (month >= 1 && month <= 12)
			this.month = month;
		else
			System.out.println("1월부터 12월 사이로 설정하세요.");
	}

	public NKH_Java_Workshop04_Magazine(String isbn, String title, String author, String publisher, int year, int month,
			int price, String desc) {
		super(isbn, title, author, publisher, price, desc);
		setYear(year);
		setMonth(month);
	}

	public NKH_Java_Workshop04_Magazine(String isbn, String title, String author, String publisher, int year, int month,
			int price) {
		super(isbn, title, author, publisher, price, null);
		setYear(year);
		setMonth(month);
	}

	public String toString() {
		return String.format("%s | %d.%d ", super.toString(), getYear(), getMonth());
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}
}