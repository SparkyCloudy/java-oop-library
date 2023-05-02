package org.library.management;

import java.util.ArrayList;

public class Library {

  private final ArrayList<Book> BOOKLIST = new ArrayList<>();
  private final ArrayList<User> USERLIST = new ArrayList<>();

  public void addMember(User user, boolean duplicateCheck) {
    try {
      if (duplicateCheck) {
        isUserIdExist(user.id());
      }

      this.USERLIST.add(user);

    } catch (LibraryException e) {
      System.out.println("UserID telah terdaftar");
    }
  }

  public void isUserIdExist(String id) throws LibraryException {
    for (User user : this.USERLIST) {
      if (user.id().equals(id)) {
        throw new LibraryException();
      }
    }
  }

  public void isBookIdExist(String id) throws LibraryException {
    for (Book book : this.BOOKLIST) {
      if (book.id().equals(id)) {
        throw new LibraryException();
      }
    }
  }

  public void giveBook(String bookId, String userId) {
    Book book = this.getBookById(bookId, getBooksList());
    this.BOOKLIST.remove(book);

    User user = this.getUserById(userId);
    int userIndex = this.getUserIndex(user);
    this.USERLIST.get(userIndex).receiveBook(book);
  }

  public void receiveBook(String bookId, String userId) {
    User user = this.getUserById(userId);
    int userIndex = this.getUserIndex(user);

    if (user == null) {
      return;
    }

    Book book = this.getBookById(bookId, user.getBorrowedBookList());
    this.BOOKLIST.add(book);

    this.USERLIST.get(userIndex).giveBook(book);
  }

  private int getUserIndex(User user) {
    return this.USERLIST.indexOf(user);
  }

  private User getUserById(String id) {
    for (User user : this.USERLIST) {
      if (user.id().equals(id)) {
        return user;
      }
    }
    return null;
  }

  private Book getBookById(String id, Book[] list) {
    for (Book book : list) {
      if (book != null && book.id().equals(id)) {
        return book;
      }
    }
    return null;
  }

  // TODO 1 tambahkan method add book
  public void addBook(Book book, boolean duplicateCheck) {
    try {
      if (duplicateCheck) {
        isBookIdExist(book.id());
      }

      this.BOOKLIST.add(book);

    } catch (LibraryException e) {
      System.out.println("BookID telah terdaftar!");
    }
  }

  public Book[] getBooksList() {
    Book[] bookArray = new Book[this.BOOKLIST.size()];
    int i = 0;
    for (Book book : this.BOOKLIST) {
      bookArray[i++] = book;
    }

    return bookArray;
  }

  public User[] getUserList() {
    User[] userArray = new User[this.USERLIST.size()];
    int i = 0;
    for (User user : this.USERLIST) {
      userArray[i++] = user;
    }

    return userArray;
  }

  public void showBooks() {
    for (Book book : getBooksList()) {
      if (book == null) {
        continue;
      }

      System.out.printf("%s %s \n", book.id(), book.title());
    }
  }

  public void showUsers() {
    for (User user : getUserList()) {
      if (user == null) {
        continue;
      }

      System.out.printf("%s %s \n", user.id(), user.name());
    }
  }

  public void showBorrowedBooks(String memberId) {
    User user = getUserById(memberId);
    if (user == null) {
      return;
    }

    for (Book book : user.getBorrowedBookList()) {
      System.out.printf("%s %s \n", book.id(), book.title());
    }
  }
}