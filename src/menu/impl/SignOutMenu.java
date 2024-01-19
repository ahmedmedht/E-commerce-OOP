package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

public class SignOutMenu implements Menu {
    private UserManagementService userManagementService;
    private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
        printMenuHeader();
    }

    @Override
    public void start() {
        if (context.getLoggedInUser()!=null){
            context.setLoggedInUser(null);
        }
        System.out.println("Have a nice day! Look forward to welcoming back!");
        Menu menu=new MainMenu();
        menu.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN OUT *****");
    }
}
