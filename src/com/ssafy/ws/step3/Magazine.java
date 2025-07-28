package com.ssafy.ws.step3;

public class Magazine extends Book {
	private int year;
	private int month;
	public Magazine() {//묵시적 super()
			}
	
	public Magazine(String isbn, String title, String author, String publisher, int price, String description, int year, int month) {
	//명시적으로 super(args) - 첫 라인에서 호출
		super(isbn, title, author, publisher, price, description);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return new StringBuilder(super.toString())
				.append("\t|").append(year)
				.append("\t|").append( month).toString();
	}
	
	
	
}
