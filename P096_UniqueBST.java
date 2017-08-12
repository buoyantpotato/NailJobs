/**
 * Created by linzhou on 8/11/17.
 */
public class P096_UniqueBST {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }

        // Time O(n^2), Space O(1)
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                cache[i] += cache[j - 1] * cache[i - j];
            }
        }

        return cache[n];
    }
}
