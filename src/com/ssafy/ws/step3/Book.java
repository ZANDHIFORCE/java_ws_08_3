package com.ssafy.ws.step3;
/**
 * 도서 정보를 나타내는 클래스
 * Encapsulation : data private, public setter/getter
 *                 구현은 hidden, 사용법 제공
 */
public class Book implements Comparable<Book>{ //정렬기준 override
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String description;
	public Book() {} //기본생성자 - overloading명시해서 사용
	//this - 현재 객체
	public Book(String isbn, String title, String author, String publisher, int price, String description) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return  isbn + "\t|"+ title + "\t|"+ author + "\t|" + publisher
				+ "\t|" + price + "\t|" + description;
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
		return author;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Book 타입의 객체 제목으로 내림차순 정렬
	 */
	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return title.compareTo(o.title)*-1;
	}
	
	
	
}

