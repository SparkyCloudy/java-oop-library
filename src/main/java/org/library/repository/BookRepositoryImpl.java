package org.library.repository;

import org.library.entity.Book;

import java.util.ArrayList;

public class BookRepositoryImpl implements BookRepository{

    private final ArrayList<Book> BOOKLIST = new ArrayList<>();

    @Override
    public void add(Book book) {
        this.BOOKLIST.add(book);
    }

    @Override
    public void remove(Book book) {
        this.BOOKLIST.remove(book);
    }

    @Override
    public Book[] getAll() {
        Book[] bookArray = new Book[this.BOOKLIST.size()];
        int i = 0;
        for (Book book : this.BOOKLIST) {
            bookArray[i++] = book;
        }

        return bookArray;
    }

}
