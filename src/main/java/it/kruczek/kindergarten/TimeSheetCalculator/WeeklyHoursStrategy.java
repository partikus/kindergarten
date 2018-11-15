package it.kruczek.kindergarten.TimeSheetCalculator;

import it.kruczek.kindergarten.TimeSheet.ChildTimeSheet;
import it.kruczek.kindergarten.TimeSheet.DailyPresence;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;

public class WeeklyHoursStrategy {

    private ChildTimeSheet childTimeSheet;
    private DailyHoursStrategy dailyHoursStrategy;

    public WeeklyHoursStrategy(ChildTimeSheet childTimeSheet, DailyHoursStrategy dailyHoursStrategy) {
        this.childTimeSheet = childTimeSheet;
        this.dailyHoursStrategy = dailyHoursStrategy;
    }

    public HashMap<Period, Float> calculate(LocalDate from, LocalDate to) {
        LocalDate monday = from.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        ArrayList<DailyPresence> presences;
        HashMap<Period, Float> reports = new HashMap<>();

        while (!monday.isAfter(to)) {
            LocalDate friday = from.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
            presences = childTimeSheet.getBy(monday, friday);
            reports.put(Period.between(monday, friday), this.calcPresences(presences)) ;

            monday = friday.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        }

        return reports;
    }

    private Float calcPresences(ArrayList<DailyPresence> presences) {
        float hours = 0;
        for (DailyPresence presence : presences) {
            hours += Math.round(dailyHoursStrategy.calculate(presence) * 10 * 4) / (10 * 4);
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
