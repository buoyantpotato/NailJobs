/**
 * Created by linzhou on 4/14/17.
 */
public class P275_HIndex2 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int len = citations.length;
        int start = 0;
        int end = citations.length;
        // 0,1,2,2,3,3,6
        // Condition: citations[target] >= citations.length - target
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] > len - mid) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (citations[start] >= len - start) {
            return len - start;
        } else {
            return len - end;
        }
    }
}
