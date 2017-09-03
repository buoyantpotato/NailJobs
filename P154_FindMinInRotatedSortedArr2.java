/**
 * Created by linzhou on 8/27/17.
 */
public class P154_FindMinInRotatedSortedArr2 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int first = 0, last = nums.length - 1;
        while (first + 1 < last) {
            int mid = first + (last - first) / 2;
            if (nums[mid] > nums[last]) {
                first = mid;
            } else if (nums[first] == nums[last]) {
                first++;
            } else {
                last = mid;
            }
        }

        return Math.min(nums[first], nums[last]);
    }
}
