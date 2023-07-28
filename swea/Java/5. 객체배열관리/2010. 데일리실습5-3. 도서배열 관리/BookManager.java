package com.ssafy.ws.step3;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManager {
	final static int MAX_SIZE = 100;
	int size = 0;

	Book[] books = new Book[MAX_SIZE];

	public void add(Book book) {
		if (size < MAX_SIZE) {
			books[size++] = book;
		} else {
			System.out.println("꽉참");
		}
	}

	public void remove(String isbn) {
		for (int i = 0; i < books.length; i++) {
			if (isbn.equals(books[i].getIsbn())) {
				System.arraycopy(books, i + 1, books, i, size - i - 1);
				size--;
				return;
			}
		}
	}

	public Book[] getList() {
		Book[] b = new Book[size];
		System.arraycopy(books, 0, b, 0, size);
		return b;
	}

	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < books.length; i++) {
			if (isbn.equals(books[i].getIsbn()))
				return books[i];
		}
		return null;
	}

}
