

public class P287_FindDupNum {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        solution1(nums);
        return solution2(nums);

    }

    // Time O(nlogn), Space O(1)
    public int solution1(int[] nums) {
        int first = 0, last = nums.length - 1;
        while (first + 1 < last) {
            int mid = first + (last - first) / 2;

            int numOfLarge = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= first && nums[i] <= last) {
                    if (nums[i] > mid) {
                        numOfLarge++;
                    }
                }
            }

            if (numOfLarge > last - mid) {
                first = mid;
            } else {
                last = mid;
            }
        }

        boolean firstFlag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first) {
                if (firstFlag) {
                    firstFlag = false;
                } else {
                    return first;
                }
            }
        }

        return last;
    }

    // Time O(n), Space O(1)
    public int solution2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
