/**
 * Created by linzhou on 3/6/17.
 */
public class P026_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int preVal = nums[0];
        int nextIndex = 0;
        int len = nums.length;
        int arrLen = nums.length;
        for (int i = 1; i < arrLen; i++) {
            if (preVal == nums[i]) {
                len--;
            } else {
                nextIndex++;
                nums[nextIndex] = nums[i];
            }
            preVal = nums[i];
        }
        return len;
    }
}
