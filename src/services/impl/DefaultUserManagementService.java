package services.impl;

import enteties.User;
import enteties.impl.DefaultUser;
import services.UserManagementService;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultUserManagementService implements UserManagementService {

    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";

    private static final int DEFAULT_USERS_CAPACITY = 10;
    private static ArrayList<User> users;
    private static int lastIndex;

    public static int id = 1;

    private static DefaultUserManagementService instance;

    // <write your code here>
    {
        users=new ArrayList<>();
    }
    private DefaultUserManagementService() {
    }
    @Override
    public User changeSetting(User user,String pass,boolean check){
//        for (int i=0;i<users.size();i++){
//            if (user.getId()==users[i].getId()){
//                if (check)
//                    users[i].setPassword(pass);
//                else
//                    users[i].setEmail(pass);
//                return users[i];
//            }
//        }

        int userIndex=users.indexOf(user);

        if (check) {
            user.setPassword(pass);
            }else{
            user.setEmail(pass);
        }
        users.set(userIndex, user);




        return user;
    }

    @Override
    public Integer getNewId() {
        return id++;
    }

    @Override
    public String registerUser(User user) {
        if (user==null)
            return null;
        users.add(user);
        return "New user is created";
    }

    public static UserManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultUserManagementService();
        }
        return instance;
    }
    public static String getEmptyEmailErrorMessage(){return EMPTY_EMAIL_ERROR_MESSAGE;}
    public static String getNotUniqueEmailErrorMessage(){return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;}

    @Override
    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        for (User user : users) {
            if (user.getEmail().equals(userEmail)) {
                return user;
            }
        }
        return null;
    }

    void clearServiceState() {
        // <write your code here>
    }
}
