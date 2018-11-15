package it.kruczek.kindergarten.User;

public class Child {
    private String firstName;
    private String lastName;
    private Address address;

    public Child(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Address getAddress() {
        return address;
    }
}
