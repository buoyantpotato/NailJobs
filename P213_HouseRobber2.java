/**
 * Created by linzhou on 8/9/17.
 */
public class P213_HouseRobber2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int cur = 0, prev = nums[0], prevPrev = nums[0];

        for (int i = 2; i < nums.length - 1; i++) {
            cur = Math.max(prev, prevPrev + nums[i]);
            max = Math.max(max, cur);

            prevPrev = prev;
            prev = cur;
        }

        cur = 0; prev = 0; prevPrev = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(prev, prevPrev + nums[i]);
            max = Math.max(max, cur);

            prevPrev = prev;
            prev = cur;
        }

        return max;
    }
}
