package java_workshop02;

public class NKH_Java_Workshop02_Magazine {
	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private int year;
	private int month;
	private int price;
	private String desc;	
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		if(month >= 1 && month <= 12)
			this.month = month;
		else
			System.out.println("1월부터 12월 사이로 설정하세요.");
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public NKH_Java_Workshop02_Magazine(){}
	
	public NKH_Java_Workshop02_Magazine(int isbn
									  , String title
									  , String author
									  , String publisher
									  , int year
									  , int month
									  , int price
									  , String desc){
		setMagazine(isbn, title, author, publisher, year, month, price, desc);
	}
	
	private void setMagazine(int isbn
			  			   , String title
			  			   , String author
			  			   , String publisher
			  			   , int year
			  			   , int month
			  			   , int price
			  			   , String desc){
		setIsbn(isbn);
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setYear(year);
		setMonth(month);
		setPrice(price);
		setDesc(desc);
	}
	
	public String toString(){
		return String.format("%d | %s\t | %s | %s\t | %d | %s | %d.%d ", getIsbn(), getTitle(), getAuthor(), getPublisher(), getPrice(), getDesc(), getYear(), getMonth());
	}

	public int getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getPrice() {
		return price;
	}

	public String getDesc() {
		return desc;
	}
	
}
