package menu.impl;

import configs.ApplicationContext;
import enteties.User;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
        printMenuHeader();
    }

    @Override
    public void start() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Please, enter your email: ");
        String email=sc.nextLine();
        System.out.print("Please, enter your password: ");
        String password=sc.nextLine();
        User user=checkEmailAndPassword(email,password);
        if (user==null){
            System.out.println("Unfortunately, such login and password doesn’t exist");
        }else {
            context.setLoggedInUser(user);
            System.out.println("Glad to see you back "+user.getFirstName()+" "+user.getLastName());
        }
        Menu menu=new MainMenu();
        menu.start();

    }

    private User checkEmailAndPassword(String email, String password) {
        User user1=userManagementService.getUserByEmail(email);
        if (user1!=null && user1.getPassword().equals(password)){
            return user1;
        }else return null;
    }

    @Override
    public void printMenuHeader() {
            System.out.println("***** SIGN IN *****");
    }
}
