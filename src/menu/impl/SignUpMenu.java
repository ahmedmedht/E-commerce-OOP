package menu.impl;

import configs.ApplicationContext;
import enteties.User;
import enteties.impl.DefaultUser;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpMenu implements Menu {
    private UserManagementService userManagementService;
    private ApplicationContext context;
    Scanner sc=new Scanner(System.in);



    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
        printMenuHeader();
    }

    @Override
    public void start() {
        User user=enterDataUser();
        Menu menu;
        if (checkUserEnterEmail(user)){
            System.out.println(DefaultUserManagementService.getEmptyEmailErrorMessage());
            menu=new SignUpMenu();
        }else if (userManagementService.getUserByEmail(user.getEmail())!=null){
            System.out.println(DefaultUserManagementService.getNotUniqueEmailErrorMessage());
            menu=new SignUpMenu();
        }
        else {
            context.setLoggedInUser(user);
            System.out.println(userManagementService.registerUser(user));
            menu=new MainMenu();
        }
        menu.start();

    }



    private boolean checkUserEnterEmail(User user) {
        String regex = "^(.+)@(.+)$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());
        return !matcher.matches();
    }


    private User enterDataUser() {
        System.out.print("Please, enter your first name: ");
        String firstName=sc.nextLine();
        System.out.print("Please, enter your last name: ");
        String lastName=sc.nextLine();
        System.out.print("Please, enter your password: ");
        String password=sc.nextLine();
        System.out.print("Please, enter your email: ");
        String email=sc.nextLine();
        return new DefaultUser(firstName,lastName,password,email);
    }


    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN UP *****");
    }
}
