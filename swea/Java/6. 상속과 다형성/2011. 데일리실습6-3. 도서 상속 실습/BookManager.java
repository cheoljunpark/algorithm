package com.ssafy.ws.step3;

import java.util.Arrays;

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

	public Book[] searchByTitle(String title) {
		int idx = 0;
		int cnt = 0;

		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title)) {
				cnt++;
			}
		}

		Book[] book = new Book[cnt];
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title)) {
				book[idx++] = books[i];
			}
		}

		return book;
	}

	public Magazine[] getMagazines() {
		int numberOfMagazine = 0;
		int idx = 0;

		for (int i = 0; i < size; i++)
			if (books[i] instanceof Magazine)
				numberOfMagazine++;

		Magazine[] magazine = new Magazine[numberOfMagazine];

		for (int i = 0; i < size; i++)
			if (books[i] instanceof Magazine)
				magazine[idx++] = (Magazine) books[i];
		return magazine;

	}

	public Book[] getBooks() {
		int numberOfBook = 0;
		int idx = 0;
		for (int i = 0; i < size; i++)
			if (!(books[i] instanceof Magazine))
				numberOfBook++;

		Book[] book = new Book[numberOfBook];
		for (int i = 0; i < size; i++)
			if (!(books[i] instanceof Magazine))
				book[idx++] = books[i];
		return book;
	}

	public int getTotalPrice() {
		int totalPrice = 0;

		for (int i = 0; i < size; i++) {
			totalPrice += books[i].getPrice();
		}

		return totalPrice;
	}

	public double getPriceAvg() {
		return getTotalPrice() / size;
	}
}
