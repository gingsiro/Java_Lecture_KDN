package java_workshop02;

public class NKH_Java_Workshop02_Book {
	private int isbn;
	private String title;
	private String author;
	private String publisher;
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

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public NKH_Java_Workshop02_Book(){}
	
	public NKH_Java_Workshop02_Book(int isbn
							   	  , String title
							   	  , String author
							   	  , String publisher
							   	  , int price
							   	  , String desc){
		setBook(isbn, title, author, publisher, price, desc);
	}
	
	private void setBook(int isbn
			   		, String title
			   		, String author
			   		, String publisher
			   		, int price
			   		, String desc){
		setIsbn(isbn);
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setPrice(price);
		setDesc(desc);
	}

	public String toString(){
		return String.format("%d | %s\t | %s | %s\t | %d | %s", getIsbn(), getTitle(), getAuthor(), getPublisher(), getPrice(), getDesc());
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

	public int getPrice() {
		return price;
	}

	public String getDesc() {
		return desc;
	}

}