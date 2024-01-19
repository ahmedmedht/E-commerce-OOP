package menu.impl;

import configs.ApplicationContext;
import menu.Menu;

import java.util.Scanner;


public class MainMenu implements Menu {
    public static final String MENU_COMMAND = "menu";
    public static boolean checkLoggedIn=false;

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign In"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List"+ System.lineSeparator() +"User input: ";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List" + System.lineSeparator() +"User input: ";

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
        printMenuHeader();
    }

    @Override
    public void start() {
        Scanner sc =new Scanner(System.in);
        checkLoggedIn=checkLoggedIn();
        if (checkLoggedIn) {
            System.out.print(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
            String userInput=sc.nextLine();
            checkUserSelectIn(userInput);
        }
        else {
            System.out.print(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
            String userInput=sc.nextLine();
            if (userInput.equals("exit"))
                System.exit(0);
            checkUserSelectOut(userInput);
        }


    }

    private boolean checkLoggedIn() {
        return context.getLoggedInUser() != null;
    }

    private void checkUserSelectOut(String userInput) {
        Menu menu ;
        switch (userInput){
            case "1":
                menu=new SignUpMenu();
                break;
            case "2":
                menu=new SignInMenu();
                break;
            case "3":
                menu=new ProductCatalogMenu();
                break;
            case "4":
                menu=new MyOrdersMenu();
                break;
            case  "5":
                menu=new SettingsMenu();
                break;
            case "6":
                menu=new CustomerListMenu();
                break;
            default:
                System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time.");
                menu=new MainMenu();
                break;

        }
        menu.start();
    }

    private void checkUserSelectIn(String userInput) {
        Menu menu ;
        switch (userInput){
            case "1":
                menu=new SignUpMenu();
                break;
            case "2":
                menu=new SignOutMenu();
                break;
            case "3":
                menu=new ProductCatalogMenu();
                break;
            case "4":
                menu=new MyOrdersMenu();
                break;
            case  "5":
                menu=new SettingsMenu();
                break;
            case "6":
                menu=new CustomerListMenu();
                break;
            default:
                System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time.");
                menu=new MainMenu();
                break;

        }
        menu.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** MAIN MENU *****");
    }

}
