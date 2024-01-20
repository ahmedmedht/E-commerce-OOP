package services.impl;

import enteties.User;
import enteties.impl.DefaultUser;
import services.UserManagementService;

import java.util.Arrays;

public class DefaultUserManagementService implements UserManagementService {

    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";

    private static final int DEFAULT_USERS_CAPACITY = 10;
    private static User[] users;
    private static int lastIndex;

    public static int id = 1;

    private static DefaultUserManagementService instance;

    // <write your code here>
    {
        users=new DefaultUser[DEFAULT_USERS_CAPACITY];
    }
    private DefaultUserManagementService() {
    }
    @Override
    public User changeSetting(User user,String pass,boolean check){
        for (int i=0;i<users.length;i++){
            if (user.getId()==users[i].getId()){
                if (check)
                    users[i].setPassword(pass);
                else
                    users[i].setEmail(pass);
                return users[i];
            }
        }
        return null;
    }

    @Override
    public Integer getNewId() {
        return id++;
    }

    @Override
    public String registerUser(User user) {
        if (user==null)
            return null;
        if (users.length <=lastIndex){
            users= Arrays.copyOf(users,users.length*2);
        }
        users[lastIndex++]=user;
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
    public User[] getUsers() {
        return users;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        for (User user1 : users){
            if (user1==null)
                return null;
            if (user1.getEmail().equals(userEmail))
                return user1;
        }
        return null;
    }

    void clearServiceState() {
        // <write your code here>
    }
}
