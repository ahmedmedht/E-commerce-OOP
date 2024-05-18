package services;

import enteties.Order;

import java.util.ArrayList;

public interface OrderManagementService {

    String addOrder(Order order);

    ArrayList<Order> getOrdersByUserId(int userId);

    ArrayList<Order> getOrders();
}
