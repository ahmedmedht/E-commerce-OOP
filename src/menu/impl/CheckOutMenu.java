package menu.impl;

import configs.ApplicationContext;
import enteties.Cart;
import enteties.Order;
import enteties.impl.DefaultOrder;
import menu.Menu;
import services.OrderManagementService;
import services.impl.DefaultOrderManagementService;

import java.util.Scanner;

public class CheckOutMenu implements Menu {

    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
        printMenuHeader();
    }

    @Override
    public void start() {
        Menu menu;
        Cart cart=context.getSessionCart();
        if (context.getLoggedInUser()==null){
            System.out.println("You are not logged in. Please, sign in or create new account");
            menu=new MainMenu();
        }else if (cart.isEmpty()){
            System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
            menu=new ProductCatalogMenu();
        }
        else {
            menu=enterCardNumber(cart);
        }
        menu.start();
    }

    private Menu enterCardNumber(Cart cart) {
        System.out.print("Enter your credit card number without spaces and press enter if you confirm purchase: ");
        Scanner sc=new Scanner(System.in);
        String numCard=sc.nextLine();
        Order order=new DefaultOrder();

        Menu menu;

        if (order.isCreditCardNumberValid(numCard)){
            order.setCreditCardNumber(numCard);
            order.setProducts(cart.getProducts());
            order.setCustomerId(context.getLoggedInUser().getId());
            System.out.println(orderManagementService.addOrder(order));
            context.setSessionCart(null);
            menu=new MainMenu();

        }else{
            System.out.println("You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time.");
            menu=new CheckOutMenu();
        }
        return menu;
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CHECKOUT *****");
    }

}
