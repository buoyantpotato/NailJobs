import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by linzhou on 3/6/17.
 */
public class P056_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });


        int lastStart = intervals.get(0).start;
        int lastEnd = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= lastEnd) {
                lastEnd = Math.max(interval.end, lastEnd);
            } else {
                res.add(new Interval(lastStart, lastEnd));
                lastStart = interval.start;
                lastEnd = interval.end;
            }
        }
        res.add(new Interval(lastStart, lastEnd));

        return res;
    }

    public class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
    }
}
