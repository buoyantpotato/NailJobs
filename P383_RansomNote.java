import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhou on 8/14/17.
 */
public class P383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) {
            return true;
        }
        if (magazine == null || magazine.length() == 0) {
            return false;
        }

        sol1(ransomNote, magazine);
        return sol2(ransomNote, magazine);
    }

    // Time O(n + m), Space O(m)   slow -- HashMap
    private boolean sol1(String ransomNote, String magazine) {
        Map<Character, Integer> cache = new HashMap<>();
        char[] note = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        for (char ch : maga) {
            if (!cache.containsKey(ch)) {
                cache.put(ch, 1);
            } else {
                cache.put(ch, cache.get(ch) + 1);
            }
        }

        for (char ch : note) {
            if (!cache.containsKey(ch)) {
                return false;
            } else {
                int num = cache.get(ch);
                if (num <= 0) {
                    return false;
                }
                cache.put(ch, num - 1);
            }
        }

        return true;
    }

    // Time O(n + m), Space O(1)   fast -- int[]
    private boolean sol2(String ransomNote, String magazine) {
        int[] cache = new int[128];
        char[] note = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        for (char ch : maga) {
            cache[ch]++;
        }

        for (char ch : note) {
            if (cache[ch] == 0) {
                return false;
            } else {
                cache[ch]--;
            }
        }

        return true;
    }
}
