package it.kruczek.kindergarten.TimeSheetCalculator;

import it.kruczek.kindergarten.TimeSheet.ChildTimeSheet;
import it.kruczek.kindergarten.TimeSheet.DailyPresence;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MonthlyHoursStrategyTest extends TestCase {
    private MonthlyHoursStrategy strategy;
    private ChildTimeSheet childTimeSheet;
    private DailyHoursStrategy dailyHoursStrategy;

    @Override
    protected void setUp() throws Exception {
        childTimeSheet = mock(ChildTimeSheet.class);
        dailyHoursStrategy = mock(DailyHoursStrategy.class);

        strategy = new MonthlyHoursStrategy(childTimeSheet, dailyHoursStrategy);
    }

    public void testWeeklyHoursCalc() throws Exception {
        DailyPresence firstDay = mock(DailyPresence.class);
        DailyPresence secondDay = mock(DailyPresence.class);
        ArrayList<DailyPresence> presences = new ArrayList<>();

        presences.add(firstDay);
        presences.add(secondDay);

        when(childTimeSheet.getByMonth(any())).thenReturn(presences);
        when(dailyHoursStrategy.calculate(firstDay)).thenReturn((float) 10);
        when(dailyHoursStrategy.calculate(secondDay)).thenReturn((float) 12);

        float hours = strategy.calculate(LocalDate.of(2018, 1, 1));

        assertEquals((float) 22.0, hours);
    }
}
