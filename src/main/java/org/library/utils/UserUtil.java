package org.library.utils;

import org.library.entity.User;
import org.library.repository.UserRepository;

import java.util.Objects;

public class UserUtil {

    private static UserRepository userRepository;

    public static void setUserRepository(UserRepository userRepo) {
        userRepository = userRepo;
    }

    public static void isUserIdExist(String id) throws LibraryException {
        for (User user : userRepository.getAll()) {
            if (user.id().equals(id)) {
                throw new LibraryException();
            }
        }
    }

    public static User getUserById(String id) throws LibraryException {
        for (User user : userRepository.getAll()) {
            if (user.id().equals(id)) {
                return user;
            }
        }

        throw new LibraryException();
    }

    public static int getUserIndex(User user) {
        int index = 0;
        for (User userIndex : userRepository.getAll()) {
            if (Objects.equals(userIndex, user)) {
                break;
            }
            index++;
        }

        return index;
    }
}
