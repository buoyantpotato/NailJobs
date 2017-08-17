import java.util.Arrays;

/**
 * Created by linzhou on 8/16/17.
 */
public class P003_LongestNonRepeatSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        sol1(s);
        return sol2(s);
    }

    // Time O(2n)~O(n), Space O(128)~O(1)
    private int sol1(String s) {
        boolean[] cache = new boolean[128];
        char[] chs = s.toCharArray();
        int max = 0, start = 0;
        for (int i = 0; i < chs.length; i++) {
            if (!cache[chs[i]]) {
                cache[chs[i]] = true;
                max = Math.max(max, i - start + 1);
            } else {
                while (start < i && chs[start] != chs[i]) {
                    cache[chs[start++]] = false;
                }
                cache[chs[start++]] = false;
                cache[chs[i]] = true;
            }
        }

        return max;
    }

    // Time O(n), Space O(128)~O(1)
    private int sol2(String s) {
        int[] cache = new int[128];
        Arrays.fill(cache, -1);
        char[] chs = s.toCharArray();
        int max = 0, start = 0;
        for (int i = 0; i < chs.length; i++) {
            if (cache[chs[i]] >= 0 && cache[chs[i]] >= start) {
                start = cache[chs[i]] + 1;
            }
            cache[chs[i]] = i;
            max = Math.max(max, i - start + 1);
        }

        return max;
    }


}
