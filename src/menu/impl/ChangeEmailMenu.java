package menu.impl;

import configs.ApplicationContext;
import enteties.User;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class ChangeEmailMenu implements Menu {
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
        User newUser=changeEmail(user);
        Menu menu;
        if (newUser==null){
            System.out.println("Error,please try again");
            menu=new SettingsMenu();
        } else {
            System.out.println("Your email has been successfully changed");
            context.setLoggedInUser(newUser);
            menu = new MainMenu();
        }
        menu.start();


    }

    private User changeEmail(User user) {
        System.out.print("Enter new email: ");
        Scanner sc=new Scanner(System.in);
        String newEmail=sc.nextLine();

        return userManagementService.changeSetting(user,newEmail,false);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CHANGE EMAIL *****");
    }
}
