package it.kruczek.kindergarten.TimeSheetCalculator;

import it.kruczek.kindergarten.TimeSheet.DailyPresence;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class DailyHoursStrategy {
    public static int UNPAID_HOURS = 5;

    public float calculate(DailyPresence presence) {
        LocalTime comeIn = presence.getComeIn();
        LocalTime comeOut = presence.getComeOut();

        return (float) comeIn.until(comeOut, ChronoUnit.MINUTES) / 60;
    }

    public boolean hasPaidHours(DailyPresence dailyPresence) {
        return calculate(dailyPresence) > DailyHoursStrategy.UNPAID_HOURS;
    }

    public float calculatePaidHours(DailyPresence dailyPresence) {
        if (!hasPaidHours(dailyPresence)) {
            return 0;
        }

        return (float) calculate(dailyPresence) - DailyHoursStrategy.UNPAID_HOURS;
    }
}
