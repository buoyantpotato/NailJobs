import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by linzhou on 8/28/17.
 */
public class P039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(candidates, 0, target, list, res);
        return res;
    }

    private void helper(int[] candidates, int cur, int target,
                        List<Integer>list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                list.add(candidates[i]);
                helper(candidates, i, target - candidates[i], list, res);
                list.remove(list.size() - 1);
            } else {
                break;
            }
        }
    }
}
