package services;

import enteties.Order;

public interface OrderManagementService {

    String addOrder(Order order);

    Order[] getOrdersByUserId(int userId);

    Order[] getOrders();
}
