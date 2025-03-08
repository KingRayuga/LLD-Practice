package Splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserManager {
    private final List<User> userList;

    private UserManager() {
        userList = new ArrayList<>();
    }

    private static class SingletonHelper {
        private static final UserManager INSTANCE = new UserManager();
    }

    public static UserManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void createUser(User user) {
        if (userList.contains(user)) {
            throw new IllegalArgumentException("User already exists in the system.");
        }
        userList.add(user);
    }

    public User getUser(UUID userId) {
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        throw new IllegalArgumentException("User not found.");
    }

    public void updateUser(UUID userId, User updatedUser) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(userId)) {
                userList.set(i, updatedUser);
                return;
            }
        }
        throw new IllegalArgumentException("User not found.");
    }

    public void deleteUser(UUID userId) {
        userList.removeIf(user -> user.getId().equals(userId));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }
}