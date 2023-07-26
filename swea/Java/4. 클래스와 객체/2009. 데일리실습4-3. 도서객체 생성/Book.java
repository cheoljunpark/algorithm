package com.ssafy.ws.step3;

/**
 * 
 * @author 박철준
 * 도서 정보를 나타내는 클래스
 */

public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;

	Book() {

	}

	Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	public String toString() {
		return this.isbn + " | " + this.title + " | " + this.author + " | " + this.publisher + " | " + this.price
				+ " | " + this.desc;
	}
}
