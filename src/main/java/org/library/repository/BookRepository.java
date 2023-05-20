package org.library.repository;

import org.library.entity.Book;

public interface BookRepository {

    Book[] getAll();

    void add(Book book);

    void remove(Book book);
}
