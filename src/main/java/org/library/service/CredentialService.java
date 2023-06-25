package org.library.service;

import java.sql.SQLException;

public interface CredentialService {

  boolean loginCheck(String username, String password) throws SQLException;
  
  boolean getLoginStatus();
}