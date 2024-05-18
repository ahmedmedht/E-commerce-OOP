package enteties.impl;

import enteties.Cart;
import enteties.Product;
import services.ProductManagementService;
import services.impl.DefaultProductManagementService;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultCart implements Cart {
    private ArrayList<Product> products;
    private static final int DEFAULT_Product_CAPACITY = 10;
    private static int lastIndex;

    {

        products=new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public void addProduct(Product productById) {
        if (products== null) {
            products = new ArrayList<>();
        }
        products.add(productById) ;

    }

    @Override
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public void clear() {
        products=null;
    }
}
