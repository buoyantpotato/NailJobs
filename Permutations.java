import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhou on 2016/11/24.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean[] cache = new boolean[nums.length];
        helper(nums, res, new ArrayList<Integer>(), cache);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> midRes,
                        boolean[] cache) {
        if (midRes.size() == nums.length) {
            res.add(midRes);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!cache[i]) {
                cache[i] = true;
                midRes.add(nums[i]);
                helper(nums, res, midRes, cache);
                midRes.remove(midRes.size() - 1);
                cache[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();
        int[] nums = {1,2,3};
        System.out.println(test.permute(nums).toString());
    }
}
