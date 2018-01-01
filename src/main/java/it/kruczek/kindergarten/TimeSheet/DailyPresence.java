package it.kruczek.kindergarten.TimeSheet;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DailyPresence {
    private static LocalTime defaultComeOut = LocalTime.of(16, 0);
    private LocalDate date;
    private LocalTime comeIn;
    private LocalTime comeOut;

    public DailyPresence(LocalDate date, LocalTime comeIn) {
        this.date = date;
        this.comeIn = comeIn;
        this.comeOut = defaultComeOut;
    }

    public DailyPresence(LocalDate date, LocalTime comeIn, LocalTime comeOut) {
        this.date = date;
        this.comeIn = comeIn;
        this.comeOut = comeOut;
    }

    public static DailyPresence from(String date, String comeIn, String comeOut) {
        return new DailyPresence(
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            LocalTime.parse(comeIn, DateTimeFormatter.ofPattern("HH:mm")),
            LocalTime.parse(comeOut, DateTimeFormatter.ofPattern("HH:mm"))
        );
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getComeIn() {
        return comeIn;
    }

    public LocalTime getComeOut() {
        return comeOut;
    }

    public void comeOut(LocalTime comeOut) {
        this.comeOut = comeOut;
    }
}
