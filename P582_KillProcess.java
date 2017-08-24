import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linzhou on 8/23/17.
 */
public class P582_KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        if (pid == null || ppid == null) {
            return res;
        }

        return sol1(pid, ppid, kill);
    }


    // Time O(2n)~O(n), Space O(2n)~O(n);
    private List<Integer> sol1(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (cache.containsKey(ppid.get(i))) {
                cache.get(ppid.get(i)).add(pid.get(i));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pid.get(i));
                cache.put(ppid.get(i), list);
            }
        }

        helper(kill, cache, res);
        return res;
    }

    private void helper(int kill, Map<Integer, List<Integer>> cache, List<Integer> res) {
        res.add(kill);
        if (!cache.containsKey(kill)) {
            return;
        }

        List<Integer> list = cache.get(kill);
        for (Integer id : list) {
            helper(id, cache, res);
        }
    }
}
