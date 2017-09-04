import java.util.HashMap;

public class P209_MinSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // O(n)
        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
        for (; start < nums.length; start++) {
            sum += nums[start];
            if (sum >= s) {
                while (end < start && sum - nums[end] >= s) {
                    sum -= nums[end++];
                }
                min = Math.min(min, start - end + 1);
            }
        }

        return min < Integer.MAX_VALUE ? min : 0;

        // O(nlogn) Binary Search
        int len = nums.length;
        int[] cumSum = new int[len];
        cumSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            cumSum[i] = cumSum[i - 1] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {

            if (nums[i] >= s) {
                return 1;
            }

            int start = 0, end = i;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                int sum = cumSum[i] - cumSum[mid] + nums[mid];
                if (sum >= s) {
                    minLen = Math.min(minLen, i - mid + 1);
                    start = mid;
                } else {
                    end = mid;
                }
            }

            if (cumSum[i] - cumSum[start] + nums[start] >= s) {
                minLen = Math.min(minLen, i - start + 1);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int n = 0;
//        n = map.get(3);
//        System.out.println(n);
    }
}
