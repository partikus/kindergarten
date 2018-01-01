package it.kruczek.kindergarten.User;

import junit.framework.TestCase;

class JakubBurczybak {
    public static String firstName = "Jakub";
    public static String lastName = "Burczybąk";
    public static String city = "Rzeszów";
    public static String postalCode = "35-612";
    public static String street = "ul. Architektów 92/1204";
}

public class ChildTest extends TestCase {

    private Child child;

    @Override
    protected void setUp() throws Exception {
        Address address = new Address(JakubBurczybak.city, JakubBurczybak.street, JakubBurczybak.postalCode);
        child = new Child(JakubBurczybak.firstName, JakubBurczybak.lastName, address);
    }

    public void testItShouldHasPersonalDetails() throws Exception {
        assertEquals(JakubBurczybak.firstName, this.child.firstName());
        assertEquals(JakubBurczybak.lastName, this.child.lastName());
        assertEquals(JakubBurczybak.city, this.child.getAddress().getCity());
        assertEquals(JakubBurczybak.postalCode, this.child.getAddress().getPostalCode());
        assertEquals(JakubBurczybak.street, this.child.getAddress().getStreet());
    }

    public void testItShouldCastUserToString() throws Exception {
        assertEquals(JakubBurczybak.firstName + " " + JakubBurczybak.lastName, this.child.toString());
    }
}
