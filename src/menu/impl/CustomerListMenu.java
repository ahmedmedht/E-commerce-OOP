package menu.impl;

import configs.ApplicationContext;
import enteties.User;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

import java.util.ArrayList;

public class CustomerListMenu implements Menu {
    private final ApplicationContext context;
    private final UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
        printMenuHeader();
    }

    @Override
    public void start() {
        Menu menu=new MainMenu();
        if (context.getLoggedInUser()==null)
            System.out.println("Please, log in or create new account to see customer list");
        printCustomerList(userManagementService.getUsers());
        menu.start();
    }

    private void printCustomerList(ArrayList<User> users) {
        for (User user:users){
            if (user!=null)
                System.out.println(user.toString());
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CUSTOMER LIST *****");
    }
}
