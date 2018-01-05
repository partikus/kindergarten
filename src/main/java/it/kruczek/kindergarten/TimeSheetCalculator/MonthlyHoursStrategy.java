package it.kruczek.kindergarten.TimeSheetCalculator;

import it.kruczek.kindergarten.TimeSheet.ChildTimeSheet;
import it.kruczek.kindergarten.TimeSheet.DailyPresence;

import java.time.LocalDate;
import java.util.ArrayList;

public class MonthlyHoursStrategy {

    private ChildTimeSheet childTimeSheet;
    private DailyHoursStrategy dailyHoursStrategy;

    public MonthlyHoursStrategy (ChildTimeSheet childTimeSheet, DailyHoursStrategy dailyHoursStrategy) {
        this.childTimeSheet = childTimeSheet;
        this.dailyHoursStrategy = dailyHoursStrategy;
    }

    public float calculate(LocalDate month) {
        ArrayList<DailyPresence> presences = childTimeSheet.getByMonth(month);

        float hours = 0;
        for (DailyPresence presence : presences) {
            hours += dailyHoursStrategy.calculate(presence);
        }

        return hours;
    }

    public float calculatePaidHours(LocalDate month) {
        ArrayList<DailyPresence> presences = childTimeSheet.getByMonth(month);

        float hours = 0;
        for (DailyPresence presence : presences) {
            hours += dailyHoursStrategy.calculatePaidHours(presence);
        }

        return hours;
    }
}
