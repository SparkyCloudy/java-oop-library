package org.library.repository;

import org.library.entity.Book;
import org.library.entity.User;

import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {

    private final ArrayList<User> USERLIST = new ArrayList<>();

    @Override
    public void add(User user) {
        this.USERLIST.add(user);
    }

    @Override
    public User[] getAll() {
        User[] userArray = new User[this.USERLIST.size()];
        int i = 0;
        for (User user : this.USERLIST) {
            userArray[i++] = user;
        }

        return userArray;
    }

    @Override
    public Book[] getBorrowedBooks(User user) {
        return user.getBorrowedBookList();
    }
}
