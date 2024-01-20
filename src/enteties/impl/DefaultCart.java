package enteties.impl;

import enteties.Cart;
import enteties.Product;
import services.ProductManagementService;
import services.impl.DefaultProductManagementService;

import java.util.Arrays;

public class DefaultCart implements Cart {
    private  Product[] products;
    private static final int DEFAULT_Product_CAPACITY = 10;
    private static int lastIndex;

    {

        products=new Product[DEFAULT_Product_CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        return products[0] == null;
    }

    @Override
    public void addProduct(Product productById) {
        if (products== null) {
            products = new Product[DEFAULT_Product_CAPACITY];
            lastIndex=0;
        }
        if (products.length <=lastIndex){
            products= Arrays.copyOf(products,products.length*2);
        }
        products[lastIndex++]= productById;

    }

    @Override
    public Product[] getProducts() {
        return products;
    }

    @Override
    public void clear() {
        products=null;
    }
}
