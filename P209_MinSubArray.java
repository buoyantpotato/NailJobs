import java.util.HashMap;

public class P209_MinSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // O(n)
//        int min = Integer.MAX_VALUE;
//        int slow = 0, fast = 0;
//        int sum = nums[0];
//
//        while (slow < nums.length) {
//            if (sum < s) {
//                if (fast + 1 < nums.length) {
//                    sum += nums[++fast];
//                } else {
//                    break;
//                }
//            } else {
//                min = Math.min(min, fast - slow + 1);
//                sum -= nums[slow++];
//            }
//        }
//
//        return (min == Integer.MAX_VALUE) ? 0 : min;

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
