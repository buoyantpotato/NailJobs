
public class P209_MinSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int slow = 0, fast = 0;
        int sum = nums[0];

        while (slow < nums.length) {
            if (sum < s) {
                if (fast + 1 < nums.length) {
                    sum += nums[++fast];
                } else {
                    break;
                }
            } else {
                min = Math.min(min, fast - slow + 1);
                sum -= nums[slow++];
            }
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
