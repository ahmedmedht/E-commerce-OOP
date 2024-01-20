package menu.impl;

import configs.ApplicationContext;
import enteties.User;
import menu.Menu;

import java.util.Scanner;

public class SettingsMenu implements Menu {
    private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
            + "2. Change Email";

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
        printMenuHeader();
    }

    @Override
    public void start() {
        User user=context.getLoggedInUser();
        Menu menu;
        if (user==null){
            System.out.println("Please, log in or create new account to change your account settings");
            menu=new MainMenu();
        }else {
            menu=showSettingMenu();
        }
        menu.start();
    }

    private Menu showSettingMenu() {
        Menu menu1;
        System.out.println("1. Change Password \n2. Change Email \n Please, enter option or type 'menu' to navigate back to the main menu: ");
        Scanner sc=new Scanner(System.in);
        String userInput=sc.nextLine();
        switch (userInput) {
            case "1" -> menu1 = new ChangePasswordMenu();
            case "2" -> menu1 = new ChangeEmailMenu();
            case "menu" -> menu1 = new MainMenu();
            default -> {
                System.out.println("Only 1, 2 is allowed. Try one more time");
                menu1 = new SettingsMenu();
            }
        }
        return menu1;
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SETTINGS *****");
    }
}
