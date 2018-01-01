package it.kruczek.kindergarten.TimeSheet;

import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalTime;

public class DailyPresenceTest extends TestCase {
    private LocalDate date;
    private DailyPresence dp;

    @Override
    protected void setUp() throws Exception {
        date = LocalDate.of(2018, 1, 1);
        dp = new DailyPresence(date, LocalTime.of(8, 10));
    }

    public void testItShouldHasDayOfPresence() throws Exception {
        assertEquals(date, dp.getDate());
    }

    public void testItShouldHasComeIn() throws Exception {
        assertEquals("08:10", dp.getComeIn().toString());
    }

    public void testItShouldHasComeOut() throws Exception {
        assertEquals("16:00", dp.getComeOut().toString());
    }

    public void testItShouldHasPossibilityToSetComeOut() throws Exception {
        dp.comeOut(LocalTime.of(14, 30));
        assertEquals("14:30", dp.getComeOut().toString());
    }

    public void testItShouldParseTextConstructor() throws Exception {
        DailyPresence presence = DailyPresence.from("2018-01-01", "08:00", "13:00");

        assertEquals(2018, presence.getDate().getYear());
        assertEquals(1, presence.getDate().getMonthValue());
        assertEquals(1, presence.getDate().getDayOfMonth());
        assertEquals("08:00", presence.getComeIn().toString());
        assertEquals("13:00", presence.getComeOut().toString());
    }
}
