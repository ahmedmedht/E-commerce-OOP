package enteties.impl;

import enteties.Order;
import enteties.Product;

import java.util.Arrays;

public class DefaultOrder implements Order {
    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

    private String creditCardNumber;
    private Product[] products;
    private int customerId;
    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        boolean checkNum=checkAllNumber(userInput);

        return userInput.length() == 16 && checkNum;
    }

    private boolean checkAllNumber(String userInput) {
        for (int i=0;i<userInput.length();i++){
            if (userInput.charAt(i) <= '0' && userInput.charAt(i) >= '9') {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public Product[] getProducts() {
        return products;
    }

    @Override
    public int getCustomerId() {
        return customerId;
    }


    @Override
    public String toString() {
        return "Order: " +
                " customer id - " + customerId +
                "  credit card number - " + creditCardNumber +
                " products - " + Arrays.toString(products) ;
    }
}
