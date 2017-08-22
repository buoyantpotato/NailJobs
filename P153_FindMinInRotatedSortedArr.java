/**
 * Created by linzhou on 8/18/17.
 */
public class P153_FindMinInRotatedSortedArr {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, j = nums.length - 1;
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[j]) {
                i = mid;
            } else {
                j = mid;
            }
        }

        return Math.min(nums[i], nums[j]);
    }
}
