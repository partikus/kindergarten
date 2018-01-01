package it.kruczek.kindergarten;

import it.kruczek.kindergarten.TimeSheet.DailyPresence;
import it.kruczek.kindergarten.TimeSheet.TimeSheet;
import it.kruczek.kindergarten.User.Address;
import it.kruczek.kindergarten.User.Child;

public class App {
    public static void main(String[] args) {
        TimeSheet timeSheet = new TimeSheet();

        Child luke = new Child("Luke", "Skywalker", new Address("Rzeszów", "ul. Architektów 123/123", "35-500"));

        timeSheet.log(luke, DailyPresence.from("2018-01-01", "08:00", "14:00"));
        timeSheet.log(luke, DailyPresence.from("2018-01-02", "08:00", "14:30"));
        timeSheet.log(luke, DailyPresence.from("2018-01-03", "08:00", "15:00"));
        timeSheet.log(luke, DailyPresence.from("2018-01-04", "08:00", "16:00"));


    }
}
