package services;

import enteties.User;

public interface UserManagementService {
    String registerUser(User user);

    User[] getUsers();

    User getUserByEmail(String userEmail);
    User changeSetting(User user,String pass,boolean check);

    Integer getNewId();
}
