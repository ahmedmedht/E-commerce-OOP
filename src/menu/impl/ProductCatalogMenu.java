package menu.impl;

import configs.ApplicationContext;
import enteties.Cart;
import enteties.Product;
import enteties.impl.DefaultCart;
import menu.Menu;
import services.ProductManagementService;
import services.impl.DefaultProductManagementService;

import java.util.Arrays;
import java.util.Scanner;

public class ProductCatalogMenu implements Menu {
    private static final String CHECKOUT_COMMAND = "checkout";
    private ApplicationContext context;
    private ProductManagementService productManagementService;


    {
        context = ApplicationContext.getInstance();
        productManagementService = DefaultProductManagementService.getInstance();
        printMenuHeader();
    }

    @Override
    public void start() {
        Menu menu;

        if (context.getLoggedInUser()==null){
            System.out.println("You are not logged in. Please, sign in or create new account");
            menu=new MainMenu();
        }else {
            for (Product product : productManagementService.getProducts()) {
                System.out.println(product.toString());
            }
            menu=enterProductId();
        }
        menu.start();
    }

    private Menu enterProductId() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Product ID to add to cart: ");
        String userInput=sc.nextLine();
        Menu menu;
        Cart cart=context.getSessionCart();
        if (userInput.charAt(0)>='0' && userInput.charAt(0)<='9'){
            Product product=productManagementService.getProductById(Integer.parseInt(userInput));

            if (product==null){
                System.out.println(DefaultProductManagementService.getMessageError());
            }
            else{
                cart.addProduct(product);
                System.out.println("Product "+product.getProductName()+ "has been added to your cart. If you want to add a new product - enter the product id. If you want to proceed with checkout - enter word ‘checkout’ to console ");
            }
            menu=new ProductCatalogMenu();
        }
        else if (userInput.equals("menu")){
            menu=new MainMenu();
            cart.clear();
        }
        else if (userInput.equals("checkout")){
            menu=new CheckOutMenu();
        }else {
            menu=new ProductCatalogMenu();
            System.out.println("Please, enter product ID if you want to add product to cart. Or enter ‘checkout’ if you want to proceed with checkout. Or enter ‘menu’ if you want to navigate back to the main menu.");
        }
        context.setSessionCart(cart);
     //   System.out.println(Arrays.toString(cart.getProducts()));

        return menu;

    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** PRODUCT CATALOG *****");
        System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back the main menu");
    }
}
