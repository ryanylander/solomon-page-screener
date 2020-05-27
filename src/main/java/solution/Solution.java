package solution;

import java.util.BitSet;
import java.util.List;

/**
 * Find the longest continuous coverage given a list of coverages.
 * 
 * Assume the days of current year is numbered 1 to 365.
 * A Coverage is defined as range of dates with a coverage start and end/term date. 
 * Eg: Cov(1, 30) means the person is covered for something for Jan of this year.
 *
 */
public class Solution {

    /**
     * Calculates the longest continuous coverage for a person.
     * The coverage may have overlap and/or gaps in coverage.
     * 
     */
    public static DateInterval longestContinuousCoverage(List<DateInterval> coverages) {

        BitSet calendar = new BitSet(365);

        for (DateInterval dateInterval : coverages) {
            for (int i = dateInterval.getEff() - 1; i < dateInterval.getTerm(); i ++) {
                calendar.set(i);
            }
        }

        DateInterval longest = null;
        DateInterval current = null;
        boolean insideCoverageWindow = false;

        for (int i = 0; i < 365; i++) {

            //Check if we are inside a coverage window.
            //If window is over, or we are at the end of the year, close the current term.
            if (insideCoverageWindow && (! calendar.get(i) || i == 364) ) {
                insideCoverageWindow = false;
                current.setTerm(i);

                //If the current window has outpaced the running record, 
                //set the longest window to this one.
                if (null == longest || current.length() > longest.length()) {
                    longest = current;
                }

            //If we have reached a new window, start a new interval.
            } else if (! insideCoverageWindow && calendar.get(i)) {
                insideCoverageWindow = true;
                current = new DateInterval(i + 1, -1);
            }
        }
        return longest;
    }
}