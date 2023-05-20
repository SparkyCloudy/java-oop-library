package org.library.service;

public interface BookService {

    void showBooks();

    void addBook(String bookTitle, String bookId);

    void showBorrowedBooks(String userId);

    void giveBook(String userId, String bookId);

    void receiveBook(String userId, String bookId);
}
