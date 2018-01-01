package it.kruczek.kindergarten.TimeSheet;

import it.kruczek.kindergarten.User.Child;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeSheet implements TimesheetRegistry {
    private Map<Child, ChildTimeSheet> timesheets;

    public TimeSheet() {
        timesheets = new HashMap<Child, ChildTimeSheet>();
    }

    @Override
    public void log(Child child, DailyPresence dailyPresence) {
        if (!timesheets.containsKey(child)) {
            timesheets.put(child, new ChildTimeSheet());
        }

        List presences = timesheets.get(child);

        if (!presences.contains(dailyPresence)) {
            presences.add(dailyPresence);
        }
    }

    @Override
    public ChildTimeSheet getPresences(Child child) {
        return timesheets.get(child);
    }
}
