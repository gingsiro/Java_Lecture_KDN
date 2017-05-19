package com.kdn.model.domain;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String pubDate;
	private int price;
	private String info;
	
	public Book(){}
	
	public Book(String isbn, String title, String author, String publisher, String pubDate, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pubDate = pubDate;
		this.price = price;
	}
	
	public Book(String isbn, String title, String author, String publisher, String pubDate, int price, String info) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pubDate = pubDate;
		this.price = price;
		this.info = info;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=").append(isbn).append(", title=").append(title).append(", author=").append(author)
				.append(", publisher=").append(publisher).append(", pubDate=").append(pubDate)
				.append(", price=").append(price).append(", info=").append(info).append("]");
		return builder.toString();
	}
	
}
