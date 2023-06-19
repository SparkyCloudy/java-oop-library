package org.library;

import org.library.repository.*;
import org.library.service.*;
import org.library.utils.*;
import org.library.view.LibraryMenuView;
import org.library.view.LoginMenuView;

public class Main {

  private static final UserRepository userRepo = new UserRepositoryImpl();
  private static final UserService userService = new UserServiceImpl(userRepo);

  private static final BookRepository bookRepo = new BookRepositoryImpl();
  private static final BookService bookService =
      new BookServiceImpl(bookRepo, userRepo);

  private static final CredentialRepository credentialRepo =
      new CredentialRepositoryImpl();
  private static final CredentialService credentialService =
      new CredentialServiceImpl(credentialRepo);

  public static void main(String[] args) {
    BookUtil.setBookRepository(bookRepo);
    UserUtil.setUserRepository(userRepo);

    var loginMenuView = new LoginMenuView(userService, credentialService);
    var libraryMenuView = new LibraryMenuView(userService, bookService);
  }
}