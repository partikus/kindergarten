package it.kruczek.kindergarten.TimeSheetCalculator;

import it.kruczek.kindergarten.TimeSheet.ChildTimeSheet;
import it.kruczek.kindergarten.TimeSheet.DailyPresence;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeeklyHoursStrategyTest extends TestCase {
    private WeeklyHoursStrategy strategy;
    private ChildTimeSheet childTimeSheet;
    private DailyHoursStrategy dailyHoursStrategy;

    @Override
    protected void setUp() throws Exception {
        childTimeSheet = mock(ChildTimeSheet.class);
        dailyHoursStrategy = mock(DailyHoursStrategy.class);

        strategy = new WeeklyHoursStrategy(childTimeSheet, dailyHoursStrategy);
    }

    public void testWeeklyHoursCalc() throws Exception {
        DailyPresence monday = mock(DailyPresence.class);
        DailyPresence theusday = mock(DailyPresence.class);
        DailyPresence wednesday = mock(DailyPresence.class);
        DailyPresence thurdsay = mock(DailyPresence.class);
        DailyPresence friday = mock(DailyPresence.class);

        ArrayList<DailyPresence> presences = new ArrayList<>();

        presences.add(monday);
        presences.add(theusday);
        presences.add(wednesday);
        presences.add(thurdsay);
        presences.add(friday);

        when(childTimeSheet.getBy(any(), any())).thenReturn(presences);
        when(dailyHoursStrategy.calculate(monday)).thenReturn((float) 5);
        when(dailyHoursStrategy.calculate(theusday)).thenReturn((float) 7);
        when(dailyHoursStrategy.calculate(wednesday)).thenReturn((float) 8);
        when(dailyHoursStrategy.calculate(thurdsay)).thenReturn((float) 10);
        when(dailyHoursStrategy.calculate(friday)).thenReturn((float) 10);

        HashMap<Period, Float> hours = strategy.calculate(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 7));

        for (Object node : hours.entrySet().toArray()) {
            Map.Entry entry = (Map.Entry) node;
            Period key = (Period) entry.getKey();
            assertEquals("", key.toString());
//            assertTrue(LocalDate.of(2018, 1, 1).isEqual());
            assertEquals((float) 40.0, entry.getValue());
        }
    }
}
