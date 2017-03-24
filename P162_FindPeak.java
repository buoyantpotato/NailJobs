
public class P162_FindPeak {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start + 1 >= end) {
            return nums[start] > nums[end] ? start : end;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
            return helper(nums, mid, end);
        } else {
            return helper(nums, start, mid);
        }
    }
}
