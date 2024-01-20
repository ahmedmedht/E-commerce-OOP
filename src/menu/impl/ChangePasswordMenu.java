package menu.impl;

import configs.ApplicationContext;
import enteties.User;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class ChangePasswordMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;


    {
        context = ApplicationContext.getInstance();
        userManagementService= DefaultUserManagementService.getInstance();
        printMenuHeader();
    }

    @Override
    public void start() {
        User user=context.getLoggedInUser();
        User newUser=changePassord(user);
        Menu menu;
        if (newUser==null){
            System.out.println("Error,please try again");
            menu=new SettingsMenu();
        } else {
            System.out.println("Your password has been successfully changed");
            context.setLoggedInUser(newUser);
            menu = new MainMenu();
        }
        menu.start();


    }

    private User changePassord(User user) {
        System.out.print("Enter new password: ");
        Scanner sc=new Scanner(System.in);
        String newPass=sc.nextLine();

        return userManagementService.changeSetting(user,newPass,true);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CHANGE PASSWORD *****");
    }
}
