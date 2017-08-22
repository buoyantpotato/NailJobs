import java.util.Arrays;

/**
 * Created by linzhou on 8/20/17.
 */
public class P274_HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        sol1(citations);
        return sol1(citations);
    }

    // Time O(nlogn), Space O(1)
    private int sol1(int[] citations) {
        Arrays.sort(citations);

        int i = 0, len = citations.length;
        while (i < len && citations[i] < len - i) {
            i++;
        }

        return len - i;
    }

    // Time O(n), Space O(n)
    private int sol2(int[] citations) {
        int len = citations.length;
        int[] cache = new int[len + 1];
        for (int cit : citations) {
            if (cit >= len) {
                cache[len]++;
            } else {
                cache[cit]++;
            }
        }

        int sum = 0;
        for (int i = len; i >= 0; i--) {
            if ((sum += cache[i]) >= i) {
                return i;
            }
        }

        return 0;
    }
}
