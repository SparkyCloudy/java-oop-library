package org.library.entity;

import java.util.ArrayList;

public class User extends Admin {

	private final ArrayList<Book> BORROWED_BOOKS = new ArrayList<>();

	public User(String name, String id) {
		super(name, id);
	}

	public Book[] getBorrowedBookList() {
		Book[] bookArray = new Book[BORROWED_BOOKS.size()];
		int i = 0;
		for (Book book : BORROWED_BOOKS) {
			bookArray[i++] = book;
		}

		return bookArray;
	}

	/**
	 * Add this book object to the ArrayList. Safer way than using ArrayList
	 * object directly
	 *
	 * @param book {@code Object} that going to be added to the ArrayList
	 */
	public void receiveBook(Book book) {
		this.BORROWED_BOOKS.add(book);
	}

	/**
	 * Remove this book object from the ArrayList. Safer way than using
	 * ArrayList object directly
	 *
	 * @param book {@code Object} that going to be added to the ArrayList
	 */
	public void giveBook(Book book) {
		this.BORROWED_BOOKS.remove(book);
	}
}
