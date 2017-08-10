import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhou on 8/9/17.
 */
public class P152_MaxProductSubArr {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        solution1(nums);
        return solution2(nums);
    }

    // Time: O(n) Space: O(n)
    private int solution2(int[] nums) {
        int[] positive = new int[nums.length];
        int[] absolute = new int[nums.length];
        positive[0] = nums[0];
        absolute[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            positive[i] = Math.max(nums[i], Math.max(positive[i - 1] * nums[i], absolute[i - 1] * nums[i]));
            absolute[i] = Math.min(nums[i], Math.min(absolute[i - 1] * nums[i], positive[i - 1] * nums[i]));
            max = Math.max(positive[i], max);
        }

        return max;
    }

    // Time: O(n) Space: O(n)
    private int solution1(int[] nums) {
        int max = nums[0];
        int product = 1;
        int start = 0, end = 0;
        List<Integer> minus = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[end++];
                if (nums[i] < 0) {
                    minus.add(i);
                }
            } else {
                max = Math.max(max, getMaxProductFromNonZeroSub(nums, start, end, product, minus));
                max = Math.max(max, 0);
                product = 1;
                start = i + 1;
                end = start;
                minus = new ArrayList<>();
            }
        }

        max = Math.max(max, getMaxProductFromNonZeroSub(nums, start, end, product, minus));

        return max;
    }

    private int getMaxProductFromNonZeroSub(int[] nums, int start, int end, int product, List<Integer> minus) {
        if (end - start == 0) {
            return 0;
        }
        if (end - start == 1) {
            return product;
        }
        if (minus.size() % 2 == 0) {
            return product;
        } else {
            int left = 1, right = 1;
            for (int i = start; i <= minus.get(0); i++) {
                left *= nums[i];
            }
            for (int i = minus.get(minus.size() - 1); i < end; i++) {
                right *= nums[i];
            }

            return left >= right ? product / left : product / right;
        }
    }
}
