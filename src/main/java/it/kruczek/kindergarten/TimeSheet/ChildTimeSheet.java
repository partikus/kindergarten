package it.kruczek.kindergarten.TimeSheet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChildTimeSheet extends ArrayList<DailyPresence> {
    public boolean wasPresent(LocalDate date) {
        return this.stream().allMatch(dailyPresence -> dailyPresence.getDate().equals(date));
    }

    public DailyPresence getBy(LocalDate presentLocalDate) {
        return this.stream().filter(p -> p.getDate().equals(presentLocalDate)).findFirst().get();
    }

    public ArrayList<DailyPresence> getBy(LocalDate from, LocalDate to) {
        return this.stream()
                .filter(dailyPresence -> dailyPresence.getDate().isEqual(from) || dailyPresence.getDate().isAfter(from))
                .filter(dailyPresence -> dailyPresence.getDate().isBefore(to) || dailyPresence.getDate().isEqual(to))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
