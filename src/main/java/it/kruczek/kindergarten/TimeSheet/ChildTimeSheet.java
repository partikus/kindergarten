package it.kruczek.kindergarten.TimeSheet;

import java.time.LocalDate;
import java.util.ArrayList;

public class ChildTimeSheet extends ArrayList<DailyPresence> {
    public boolean wasPresent(LocalDate date) {
        return this.stream().allMatch(dailyPresence -> dailyPresence.getDate().equals(date));
    }

    public DailyPresence getBy(LocalDate presentLocalDate) {
        return this.stream().filter(p -> p.getDate().equals(presentLocalDate)).findFirst().get();
    }
}
