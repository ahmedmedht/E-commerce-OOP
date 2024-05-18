package services;

import enteties.Product;

import java.util.ArrayList;

public interface ProductManagementService {
    ArrayList<Product> getProducts();

    Product getProductById(int productIdToAddToCart);
}
