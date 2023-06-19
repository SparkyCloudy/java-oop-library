package org.library.service;

import org.library.repository.CredentialRepository;

public class CredentialServiceImpl implements CredentialService {

  private final CredentialRepository credentialRepository;

  public CredentialServiceImpl(CredentialRepository credentialRepository) {
    this.credentialRepository = credentialRepository;
  }

  @Override
  public boolean loginCheck(String username, String password) {

    while (!username.equals()) {

    }
  }
}
