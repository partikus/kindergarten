package it.kruczek.kindergarten.TimeSheetCalculator;

import it.kruczek.kindergarten.TimeSheet.DailyPresence;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DailyHoursStrategy {
    public static int UNPAID_HOURS = 5;
    public static LocalTime unpaidHoursBeginAt = LocalTime.of(8, 0);
    public static LocalTime unpaidHoursEndAt = LocalTime.of(13, 0);

    public float calculate(DailyPresence presence) {
        LocalTime comeIn = presence.getComeIn();
        LocalTime comeOut = presence.getComeOut();

        return (float) comeIn.until(comeOut, ChronoUnit.MINUTES) / 60;
    }

    public boolean hasPaidHours(DailyPresence dailyPresence) {
        return dailyPresence.getComeIn().isBefore(unpaidHoursBeginAt) || dailyPresence.getComeOut().isAfter(unpaidHoursEndAt);
    }

    public float calculatePaidHours(DailyPresence dailyPresence) {
        if (!hasPaidHours(dailyPresence)) {
            return 0;
        }

        float paidHours = 0;
        paidHours += calcPaidHours(dailyPresence.getComeIn(), unpaidHoursBeginAt);
        paidHours += calcPaidHours(unpaidHoursEndAt, dailyPresence.getComeOut());

        return paidHours;
    }

    private float calcPaidHours(LocalTime from, LocalTime to) {
        int minutes = (int) from.until(to, ChronoUnit.MINUTES);
        float paidHours = (float) Math.floor(minutes / 60);
        int restMinutes = minutes % 60;

        if (restMinutes >= 15 && restMinutes <= 30) {
            paidHours += 0.5;
        } else if (restMinutes > 30) {
            paidHours += 1;
        }

        return paidHours;
    }
}
