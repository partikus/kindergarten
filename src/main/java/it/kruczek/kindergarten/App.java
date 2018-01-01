package it.kruczek.kindergarten;

import it.kruczek.kindergarten.TimeSheet.ChildTimeSheet;
import it.kruczek.kindergarten.TimeSheet.DailyPresence;
import it.kruczek.kindergarten.TimeSheet.TimeSheet;
import it.kruczek.kindergarten.TimeSheetCalculator.DailyHoursStrategy;
import it.kruczek.kindergarten.User.Address;
import it.kruczek.kindergarten.User.Child;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        TimeSheet timeSheet = new TimeSheet();

        Child luke = new Child("Luke", "Skywalker", new Address("Rzeszów", "ul. Architektów 123/123", "35-500"));

        timeSheet.log(luke, DailyPresence.from("2018-01-01", "08:00", "14:00"));
        timeSheet.log(luke, DailyPresence.from("2018-01-02", "08:00", "14:30"));
        timeSheet.log(luke, DailyPresence.from("2018-01-03", "08:00", "15:00"));
        timeSheet.log(luke, DailyPresence.from("2018-01-04", "08:00", "16:00"));

        ChildTimeSheet lukeTimesheet = timeSheet.getPresences(luke);

        ArrayList<DailyPresence> presences = lukeTimesheet.getBy(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 3));

        DailyHoursStrategy strategy = new DailyHoursStrategy();

        System.out.println(luke.toString());
        for (DailyPresence presence : presences) {
            System.out.print("Date: ");
            System.out.print(presence.getDate().toString());
            System.out.print("\t");
            System.out.print("Paid hours: ");
            System.out.println(strategy.calculatePaidHours(presence));
        }

    }
}
