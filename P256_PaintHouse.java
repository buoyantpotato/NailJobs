/**
 * Created by linzhou on 8/13/17.
 */
public class P256_PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        // Time O(n), Space O(1)
        int[] dp = new int[3];
        for (int i = 0; i < costs.length; i++) {
            int[] temp = new int[3];
            temp[0] = Math.min(dp[1], dp[2]) + costs[i][0];
            temp[1] = Math.min(dp[0], dp[2]) + costs[i][1];
            temp[2] = Math.min(dp[0], dp[1]) + costs[i][2];
            dp = temp;
        }

        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }
}
