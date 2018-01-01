package it.kruczek.kindergarten.TimeSheet;

import it.kruczek.kindergarten.User.Child;

public interface TimesheetRegistry {
    void log(Child child, DailyPresence dailyPresence);
    ChildTimeSheet getPresences(Child child);
}
