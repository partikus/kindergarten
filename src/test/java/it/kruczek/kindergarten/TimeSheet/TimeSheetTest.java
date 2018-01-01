package it.kruczek.kindergarten.TimeSheet;

import it.kruczek.kindergarten.User.Child;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;

public class TimeSheetTest extends TestCase {
    private TimeSheet ts;
    private Child child;

    @Override
    protected void setUp() throws Exception {
        child = mock(Child.class);
        ts = new TimeSheet();
    }

    public void testItShouldBeAnInstanceOfTimeSheetRegistry() {
        assertTrue(ts instanceof TimesheetRegistry);
    }

    public void testItShouldBePossibleToLogHours() throws Exception {
        DailyPresence presence = new DailyPresence(
                LocalDate.of(2018, 1, 1),
                LocalTime.of(8, 0),
                LocalTime.of(14, 0)
        );

        ts.log(child, presence);
    }

    public void testItShouldHasListOfPresences() {
        DailyPresence presence = new DailyPresence(
                LocalDate.of(2018, 1, 1),
                LocalTime.of(8, 0),
                LocalTime.of(14, 0)
        );

        ts.log(child, presence);

        assertEquals(1, ts.getPresences(child).size());
    }
}
