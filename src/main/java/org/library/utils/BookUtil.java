package org.library.utils;

import org.library.entity.Book;
import org.library.repository.BookRepository;

public class BookUtil {

    private static BookRepository bookRepository;

    public static void setBookRepository(BookRepository bookRepo) {
        bookRepository = bookRepo;
    }

    public static void isBookIdExist(String id) throws LibraryException {
        for (Book book : bookRepository.getAll()) {
            if (book.id().equals(id)) {
                throw new LibraryException();
            }
        }
    }

    public static Book getBookById(String id, Book[] list) throws LibraryException {
        for (Book book : list) {
            if (book.id().equals(id)) {
                return book;
            }
        }

        throw new LibraryException();
    }
}
