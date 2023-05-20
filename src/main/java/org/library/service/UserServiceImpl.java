package org.library.service;

import org.library.entity.User;
import org.library.repository.UserRepository;
import org.library.utils.LibraryException;
import org.library.utils.UserUtil;

import java.util.Objects;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void showUsers() {
        for (User user : userRepository.getAll()) {
            if (Objects.isNull(user)) {
                continue;
            }

            System.out.printf("%s %s \n", user.id(), user.name());
        }
    }

    @Override
    public void addUser(String name, String id) {
        try {
            var user = new User(name, id);
            UserUtil.isUserIdExist(user.id());
            userRepository.add(user);

        } catch (LibraryException e) {
            System.out.println("UserID telah terdaftar");
        }
    }


}
