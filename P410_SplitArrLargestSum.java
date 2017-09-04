/**
 * Created by linzhou on 9/3/17.
 */
public class P410_SplitArrLargestSum {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length < m) {
            return 0;
        }

        return sol1(nums, m);
    }

    // Time O(S * logn), Space O(1)
    private int sol1(int[] nums, int m) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Binary search the at-most max value
        long first = 0, last = sum;
        while (first + 1 < last) {
            long mid = first + (last - first) / 2;
            if (isValid(nums, m, mid)) {
                last = mid;
            } else {
                first = mid;
            }
        }

        return (int) last;
    }

    private boolean isValid(int[] nums, int m, long mid) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > mid) {
                count = 0;
                i--;
                m--;
            }
            if (m <= 0) {
                return false;
            }
        }
        return true;
    }

}
