/**
 * Created by linzhou on 8/9/17.
 */
public class P169_MajorElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Time: O(n), Space: O(1)
        int count = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                cur = nums[i];
                count = 1;
            }
        }

        return cur;
    }
}
