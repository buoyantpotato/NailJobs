/**
 * Created by linzhou on 8/9/17.
 */
public class P198_HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        sol1(nums);

        return sol2(nums);
    }

    // Time: O(n), Space: O(n)
    private int sol1(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            max = Math.max(dp[i], max);
        }

        return max;
    }

    // Time: O(n), Space: O(1)
    private int sol2(int[] nums) {
        int max = nums[0];
        int cur = 0;
        int prev = nums[0];
        int prevPrev = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(prev, prevPrev + nums[i]);
            max = Math.max(cur, max);

            prevPrev = prev;
            prev = cur;
        }

        return max;
    }
}
