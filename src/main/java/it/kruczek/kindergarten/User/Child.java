package it.kruczek.kindergarten.User;

public class Child {
    private final String firstName;
    private final String lastName;
    private final Address address;

    public Child(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public Address getAddress() {
        return address;
    }
}
