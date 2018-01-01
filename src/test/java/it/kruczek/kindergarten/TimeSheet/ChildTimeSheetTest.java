package it.kruczek.kindergarten.TimeSheet;

import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalTime;

public class ChildTimeSheetTest extends TestCase {
    private ChildTimeSheet childTimeSheet;
    private LocalDate presentLocalDate = LocalDate.of(2018, 1, 1);
    private LocalDate absentLocalDate = LocalDate.of(2018, 1, 2);

    @Override
    protected void setUp() throws Exception {
        DailyPresence presence = new DailyPresence(
                presentLocalDate,
                LocalTime.of(8, 0),
                LocalTime.of(14, 0)
        );

        childTimeSheet = new ChildTimeSheet();
        childTimeSheet.add(presence);
    }

    public void testItShouldCheckIfChildWasPresentAt() throws Exception {
        assertTrue(childTimeSheet.wasPresent(presentLocalDate));
        assertFalse(childTimeSheet.wasPresent(absentLocalDate));
    }

    public void testItShouldReturnPresenceByDate() throws Exception {
        assertNotNull(childTimeSheet.getBy(presentLocalDate));
    }
}
