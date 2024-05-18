package enteties;

import java.util.ArrayList;
import java.util.Arrays;

public interface Order {
    boolean isCreditCardNumberValid(String userInput);

    void setCreditCardNumber(String userInput);

    void setProducts(ArrayList<Product> products);

    void setCustomerId(int customerId);

    int getCustomerId();

}
