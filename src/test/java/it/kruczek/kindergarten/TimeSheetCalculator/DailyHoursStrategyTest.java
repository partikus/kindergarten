package it.kruczek.kindergarten.TimeSheetCalculator;

import it.kruczek.kindergarten.TimeSheet.DailyPresence;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DailyHoursStrategyTest extends TestCase {
    private DailyHoursStrategy strategy;
    private ArrayList<DailyPresence> testExamples;

    @Override
    protected void setUp() throws Exception {
        strategy = new DailyHoursStrategy();
        testExamples = new ArrayList<DailyPresence>();
    }

    public void testCalcHours() throws Exception {
        DailyPresence presence;

        presence = createEntryAndAppend(8, 0, 13, 0);
        assertEquals((float) 5.0, strategy.calculate(presence));

        presence = createEntryAndAppend(6, 0, 13, 15);
        assertEquals((float) 7.25, strategy.calculate(presence));

        presence = createEntryAndAppend(6, 30, 15, 30);
        assertEquals((float) 9.0, strategy.calculate(presence));
    }

    public void testCalcPaidHours() throws Exception {
        DailyPresence presence;

        presence = createEntryAndAppend(8, 0, 13, 0);
        assertEquals((float) 0, strategy.calculatePaidHours(presence));

        presence = createEntryAndAppend(6, 0, 13, 15);
        assertEquals((float) 2.25, strategy.calculatePaidHours(presence));

        presence = createEntryAndAppend(6, 30, 15, 30);
        assertEquals((float) 4.0, strategy.calculatePaidHours(presence));
    }

    public void testHasPaidHours() throws Exception {
        DailyPresence presence;

        presence = createEntryAndAppend(8, 0, 13, 0);
        assertFalse(strategy.hasPaidHours(presence));

        presence = createEntryAndAppend(7, 0, 13, 0);
        assertTrue(strategy.hasPaidHours(presence));
    }

    private DailyPresence createEntryAndAppend(int comeInHour, int comeInMinute, int comeOutHour, int comeOutMinute) {
        DailyPresence entry = new DailyPresence(
                LocalDate.of(2018, 1, 1),
                LocalTime.of(comeInHour, comeInMinute),
                LocalTime.of(comeOutHour, comeOutMinute)
        );

        return entry;
    }
}
