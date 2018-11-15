package it.kruczek.kindergarten.Rest.Controller;

import it.kruczek.kindergarten.User.Address;
import it.kruczek.kindergarten.User.Child;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ChildController {
    @GetMapping("/children")
    public ArrayList<Child> children() {
        ArrayList children = new ArrayList<Child>();
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));
        children.add(new Child("Michal", "Kruczek", new Address("Rzeszow", "Architektow", "12-123")));

        return children;
    }

    @PostMapping("/children")
    public Child create(@RequestBody Child child) {
        return child;
    }
}
