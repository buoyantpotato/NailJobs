import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhou on 9/3/17.
 */
public class P523_ContinuousSubArrSum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }

        // Time O(n), Space O(k)
        Map<Integer, Integer> cache = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum % k == 0 && i != 0) {
                return true;
            }

            int mod = sum % k;
            if (cache.containsKey(mod)) {
                if (i - cache.get(mod) > 1) {
                    return true;
                }
            } else {
                cache.put(mod, i);
            }
        }

        return false;
    }
}
