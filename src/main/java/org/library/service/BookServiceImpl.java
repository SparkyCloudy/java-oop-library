package org.library.service;

import org.library.entity.Book;
import org.library.entity.User;
import org.library.repository.BookRepository;
import org.library.repository.UserRepository;
import org.library.utils.BookUtil;
import org.library.utils.LibraryException;
import org.library.utils.UserUtil;

import java.util.Objects;

public class BookServiceImpl implements BookService{

    BookRepository bookRepository;
    UserRepository userRepository;

    public BookServiceImpl(BookRepository bookRepository,
                           UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void showBooks() {
        for (Book book :bookRepository.getAll()) {
            if (Objects.isNull(book)) {
                continue;
            }

            System.out.printf("%s %s \n", book.id(), book.title());
        }
    }

    @Override
    public void addBook(String bookTitle, String bookId) {
        try {
            BookUtil.isBookIdExist(bookId);

            var book = new Book(bookTitle, bookId);
            bookRepository.add(book);
            System.out.printf("Sukses menambahkan Buku %s dengan ID %s \n",
                    book.title(), book.id());
        } catch (LibraryException e) {
            System.out.println("BookID telah terdaftar");
        }
    }

    @Override
    public void showBorrowedBooks(String userId) {
        try {
            User user = UserUtil.getUserById(userId);

            Book[] bookList = userRepository.getBorrowedBooks(user);

            if (bookList.length == 0) {
                System.out.println("User tidak meminjam buku.");
                return;
            }

            for (Book book : bookList) {
                System.out.printf("%s %s \n", book.id(), book.title());
            }
        } catch (LibraryException e) {
            System.out.println("User tidak ditemukan");
        }
    }

    @Override
    public void giveBook(String userId, String bookId) {
        try {
            User user = UserUtil.getUserById(userId);
            Book book = BookUtil.getBookById(bookId, bookRepository.getAll());
            bookRepository.remove(book);
            user.receiveBook(book);
        } catch (LibraryException e) {
            System.out.println("User/Buku tidak ditemukan");
        }
    }

    @Override
    public void receiveBook(String userId, String bookId) {
        try {
            User user = UserUtil.getUserById(userId);
            Book book = BookUtil.getBookById(bookId, user.getBorrowedBookList());
            bookRepository.add(book);
            user.giveBook(book);
        } catch (LibraryException e) {
            System.out.println("User/Buku tidak ditemukan");
        }
    }
}
