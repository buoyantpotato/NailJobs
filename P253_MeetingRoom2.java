import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by linzhou on 9/3/17.
 */
public class P253_MeetingRoom2 {

     public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        sol1(intervals);
        return sol2(intervals);
    }


    // Time O(nlogn), Space O(n)
    private int sol1(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) {
                    return i1.start - i2.start;
                } else {
                    return i1.end - i2.end;
                }
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            int endTime = pq.peek();
            if (endTime <= intervals[i].start) {
                pq.remove();
                pq.add(intervals[i].end);
            } else {
                pq.add(intervals[i].end);
            }
        }

        return pq.size();
    }

    // Time O(nlogn), Space O(n)
    private int sol2(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int numRoom = 0, s = 0, e = 0;
        while (s < start.length) {
            if (start[s] < end[e]) {
                numRoom++;
                s++;
            } else {
                s++;
                e++;
            }
        }

        return numRoom;
    }
}
