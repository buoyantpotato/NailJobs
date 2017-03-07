import java.util.HashMap;

/**
 * Created by linzhou on 3/6/17.
 */
public class P001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1 ) {
            return new int[2];
        }

        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.get(nums[i]) != null) {
                int[] res = {cache.get(nums[i]), i};
                return res;
            }
            cache.put(target - nums[i], i);
        }

        return new int[2];
    }
}
