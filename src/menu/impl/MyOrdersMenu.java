package menu.impl;

import configs.ApplicationContext;
import enteties.Order;
import enteties.impl.DefaultOrder;
import menu.Menu;
import services.OrderManagementService;
import services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {
    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
        printMenuHeader();
    }

    @Override
    public void start() {
        Menu menu=new MainMenu();

        if (context.getLoggedInUser()==null){
            System.out.println("Please, log in or create new account to see list of your orders");
            menu.start();
        }
        int idUser=context.getLoggedInUser().getId();
        Order[] orders=orderManagementService.getOrdersByUserId(idUser);
        if (orders==null){
            System.out.println("Unfortunately, you don’t have any orders yet. Navigate back to main menu to place a new order");
        }
        else {
            printUserOrder(orders);
        }
        menu.start();
    }

    private void printUserOrder( Order[] orders) {

            for (Order ord:orders){
                System.out.println(ord.toString());
            }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** MY ORDERS *****");
    }
}
