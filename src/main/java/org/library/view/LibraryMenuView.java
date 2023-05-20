package org.library.view;

import org.library.service.BookService;
import org.library.service.UserService;
import org.library.utils.*;

public final class LibraryMenuView {

    private final UserService userService;
    private final BookService bookService;

    public LibraryMenuView(UserService userService, BookService bookService) {
        this.bookService = bookService;
        this.userService = userService;
        choose();
    }

    private void showMainMenu() {
        System.out.println("================================");
        System.out.println("1. show books list");
        System.out.println("2. show users list");
        System.out.println("3. show borrowed books list");
        System.out.println("4. add member");
        System.out.println("5. add book");
        System.out.println("6. borrow book");
        System.out.println("7. return book");
        System.out.println("================================");
    }

    private void choose() {
        initLibraryData();
        String isContinue = "y";

        while (isContinue.isBlank() || isContinue.isEmpty()
                || isContinue.equalsIgnoreCase("y")) {

            showMainMenu();
            String selectedMenu = InputUtil.input("choose menu: ");

            try {
                switch (Integer.parseInt(selectedMenu)) {
                    case 1 -> showBooks();
                    case 2 -> showUsers();
                    case 3 -> showBorrowedBooks();
                    case 4 -> addUser();
                    case 5 -> addBook();
                    case 6 -> borrowBook();
                    case 7 -> returnBook();
                    default -> System.out.println("Pilihan tidak ditemukan!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Harus berupa angka!");
            }

            isContinue = InputUtil.input("continue (Y/n)? ");
//            ConsoleUtils.clear();
        }
    }

    private void initLibraryData() {
        bookService.addBook("pemrograman java", "1");
        bookService.addBook("pemrograman oop", "2");
        bookService.addBook("pemrograman c++", "3");

        userService.addUser("aka", "1");
        userService.addUser("budi", "2");
        userService.addUser("tono", "3");
    }

    private void showBooks() {
        System.out.println("List buku yang terdaftar");
        bookService.showBooks();
    }

    private void showUsers() {
        System.out.println("List user yang terdaftar");
        userService.showUsers();
    }

    private  void addUser() {
        System.out.println("Tambahkan User");
        String name = InputUtil.input("name: ");
        String id = InputUtil.input("id: ");
        userService.addUser(name, id);
    }

    private void showBorrowedBooks() {
        String userId = InputUtil.input("id member: ");
        bookService.showBorrowedBooks(userId);
    }

    private void borrowBook() {
        String userId = InputUtil.input("id member: ");
        String bookId = InputUtil.input("id book: ");
        bookService.giveBook(userId, bookId);
    }

    private void returnBook() {
        String userId = InputUtil.input("id member: ");
        String bookId = InputUtil.input("id book: ");
        bookService.receiveBook(userId, bookId);
    }

    private void addBook() {
        String title = InputUtil.input("book title: ");
        String id = InputUtil.input("book id: ");
        bookService.addBook(title, id);
    }
}
