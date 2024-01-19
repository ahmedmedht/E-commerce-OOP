package enteties.impl;

import enteties.User;

public class DefaultUser implements User {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private static int id;
    {
        id+=1;
    }

    public DefaultUser() {
    }

    public DefaultUser(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer: " +
                "firstName= " + firstName +
                " lastName= " + lastName +
                " email= " + email;
    }




    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getId() {
        // <write your code here>
        return id;
    }

    void clearState() {

    }
}
