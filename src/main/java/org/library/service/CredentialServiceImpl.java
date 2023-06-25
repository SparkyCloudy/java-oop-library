package org.library.service;

import org.library.repository.CredentialRepository;
import org.library.utils.ConnectionUtil;
import org.library.utils.LibraryException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CredentialServiceImpl implements CredentialService {

  private final CredentialRepository credentialRepository;
  private static int loginCounter = 0;

  public CredentialServiceImpl(CredentialRepository credentialRepository) {
    this.credentialRepository = credentialRepository;
  }

  @Override
  public boolean loginCheck(String username, String password) {
    String sql = String.format("""
        SELECT * FROM user WHERE username = '%s' AND password = '%s'
        """, username, password);
    
    try (ResultSet rs = ConnectionUtil.resultSet(sql)) {
      if (rs.next()) {
        if (rs.getRow() > 0) return true;
      }
    } catch (SQLException e) {
      LibraryException.getError(e);
    }
    
    CredentialServiceImpl.loginCounter++;
    
    return false;
  }
  
  @Override
  public boolean getLoginStatus() {
    return CredentialServiceImpl.loginCounter >= 3;
  }
}
