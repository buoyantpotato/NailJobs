/**
 * Created by linzhou on 8/14/17.
 */
public class P091_DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }

        // XX X
        // X XX
        sol1(s);
        return sol2(s);
    }

    // Time O(n), Space O(n)
    private int sol1(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        char[] chs = s.toCharArray();
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != '0') {
                dp[i + 1] += dp[i];
            }
            if (chs[i - 1] == '1' || (chs[i - 1] == '2' && chs[i] >= '0' && chs[i] <= '6')) {
                dp[i + 1] += dp[i - 1];
            }
        }

        return dp[s.length()];
    }

    // Time O(n), Space O(1)
    private int sol2(String s) {
        int prevPrev = 1, prev = 1, cur = 0;
        char[] chs = s.toCharArray();
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != '0') {
                cur += prev;
            }
            if (chs[i - 1] == '1' || (chs[i - 1] == '2' && chs[i] >= '0' && chs[i] <= '6')) {
                cur += prevPrev;
            }

            prevPrev = prev;
            prev = cur;
            cur = 0;
        }

        return prev;
    }
}
