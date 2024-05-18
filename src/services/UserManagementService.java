package services;

import enteties.User;

import java.util.ArrayList;

public interface UserManagementService {
    String registerUser(User user);

    ArrayList<User> getUsers();

    User getUserByEmail(String userEmail);
    User changeSetting(User user,String pass,boolean check);

    Integer getNewId();
}
