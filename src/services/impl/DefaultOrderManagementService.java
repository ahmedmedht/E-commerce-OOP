package services.impl;

import enteties.Cart;
import enteties.Order;
import services.OrderManagementService;

import java.util.Arrays;

public class DefaultOrderManagementService implements OrderManagementService {
    private static final int DEFAULT_ORDER_CAPACITY = 10;
    private static Order[] orders;
    private static int lastIndex;
    private static DefaultOrderManagementService instance;
    {
        orders=new Order[DEFAULT_ORDER_CAPACITY];
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
        if (orders.length <=lastIndex){
            orders= Arrays.copyOf(orders,orders.length*2);
        }
        orders[lastIndex++]=order;
        return "Thanks a lot for your purchase. Details about order delivery are sent to your email.";
    }

    @Override
    public Order[] getOrdersByUserId(int userId) {
        Order[] orderUser=new Order[orders.length];
        int index=0;
        boolean checkOrder=false;

        for (Order order:orders) {
            if (order!=null) {
                if (order.getCustomerId() == userId) {
                    orderUser[index++] = order;
                    checkOrder = true;
                }
            }
        }
        if (checkOrder)
        return orderUser;
        else return null;
    }

    @Override
    public Order[] getOrders() {
        return orders;
    }

    void clearServiceState() {
    }
}
