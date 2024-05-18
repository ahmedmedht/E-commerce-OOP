package services.impl;

import enteties.Cart;
import enteties.Order;
import services.OrderManagementService;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultOrderManagementService implements OrderManagementService {
    private static final int DEFAULT_ORDER_CAPACITY = 10;
    private static ArrayList<Order> orders;
    private static int lastIndex;
    private static DefaultOrderManagementService instance;
    {
        orders=new ArrayList<>();
    }
    // <write your code here>

    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public String addOrder(Order order) {
        if (order==null)
            return null;
        orders.add(order);
        return "Thanks a lot for your purchase. Details about order delivery are sent to your email.";
    }

    @Override
    public ArrayList<Order> getOrdersByUserId(int userId) {
        ArrayList<Order> orderUser=new ArrayList<>();
        for (Order order:orders) {
            if (order!=null) {
                if (order.getCustomerId() == userId) {
                    orderUser.add(order);
                }
            }
        }
        return orderUser;
    }

    @Override
    public ArrayList<Order> getOrders() {
        return orders;
    }

    void clearServiceState() {
    }
}
