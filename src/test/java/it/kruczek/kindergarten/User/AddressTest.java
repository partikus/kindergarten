package it.kruczek.kindergarten.User;

import junit.framework.TestCase;

public class AddressTest extends TestCase {
    private static String city = "Rzeszów";
    private static String postalCode = "35-612";
    private static String street = "ul. Architektów 124/12";

    private Address address;

    @Override
    protected void setUp() throws Exception {
        this.address = new Address(city, street, postalCode);
    }

    public void testItShouldBeAnInstanceOfAddress() throws Exception {
        assertEquals(Address.class, this.address.getClass());
    }

    public void testShouldHasAllFields() throws Exception {
        assertEquals(city, this.address.getCity());
        assertEquals(postalCode, this.address.getPostalCode());
        assertEquals(street, this.address.getStreet());
    }
}
