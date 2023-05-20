package org.library.repository;

import org.library.entity.Book;
import org.library.entity.User;

public interface UserRepository {

    void add(User user);

    User[] getAll();

    Book[] getBorrowedBooks(User user);
}
