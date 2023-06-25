package org.library.view;

import org.library.service.CredentialService;
import org.library.service.UserService;
import org.library.utils.InputUtil;
import org.library.utils.LibraryException;

import java.sql.SQLException;

public final class LoginMenuView {

  private final UserService userService;
  private final CredentialService credentialService;

  public LoginMenuView(UserService userService,
                       CredentialService credentialService) {
    this.userService = userService;
    this.credentialService = credentialService;
    init();
  }

  public void init() {
    while (true) {
      var username = InputUtil.loginInput("Username");
      var password = InputUtil.loginInput("Password");
      
      try {
        if (credentialService.loginCheck(username, password)) {
          System.out.println("Login Berhasil!");
          break;
        } else if (credentialService.getLoginStatus()) {
          break;
        } else {
          System.out.println("Username/Password tidak sesuai!");
        }
      } catch (SQLException e) {
        LibraryException.getError(e);
      }
    }
  }
}
