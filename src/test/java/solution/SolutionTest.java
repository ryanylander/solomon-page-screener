package solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import solution.DateInterval;
import solution.Solution;

/**
 * Unit test for screener solution.
 */
public class SolutionTest 
{
    /**
     * Test for the provided sample data:
     * 
     * val coverages = List(
        Cov(1, 20), Cov(21, 30), Cov(15, 25), Cov(28, 40), Cov(50, 60), Cov(61, 200)
     */
    @Test
    public void testFindsCorrectInterval()
    {
        List<DateInterval> intervals = new ArrayList();
        intervals.add(new DateInterval(1, 20));
        intervals.add(new DateInterval(21, 30));
        intervals.add(new DateInterval(15, 25));
        intervals.add(new DateInterval(28, 40));
        intervals.add(new DateInterval(50, 60));
        intervals.add(new DateInterval(61, 200));

        Solution solution = new Solution();
        DateInterval answer = solution.longestContinuousCoverage(intervals);

        assertEquals(answer.getEff(), 50);
        assertEquals(answer.getTerm(), 200);
    }
}
