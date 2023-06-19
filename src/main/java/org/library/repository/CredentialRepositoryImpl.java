package org.library.repository;

import org.library.entity.User;

import java.util.ArrayList;

public class CredentialRepositoryImpl implements CredentialRepository {
	
	private final ArrayList<User> USER_CREDENTIAL = new ArrayList<>();
	
	@Override
	public User[] getAll() {
		int i = 0;
		User[] allCredential = new User[this.USER_CREDENTIAL.size()];
		for (User credential : this.USER_CREDENTIAL) {
			allCredential[i++] = credential;
			
		}
		
		return allCredential;
	}
}
