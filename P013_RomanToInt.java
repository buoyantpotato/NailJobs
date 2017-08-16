import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhou on 8/15/17.
 */
public class P013_RomanToInt {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        sol1(s);
        return sol2(s);
    }


    // Time O(n), Space O(1)  Slow because of Map
    private int sol1(String s) {
        final Map<Character, Integer> cache = new HashMap<>();
        cache.put('I', 1);
        cache.put('V', 5);
        cache.put('X', 10);
        cache.put('L', 50);
        cache.put('C', 100);
        cache.put('D', 500);
        cache.put('M', 1000);

        int res = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int num = cache.get(chs[i]);
            res += num;
            if (i + 1 < chs.length && num < cache.get(chs[i + 1])) {
                res -= 2* num;
            }
        }

        return res;
    }

    // Time O(n), Space O(1)  Fast because of switch
    private int sol2(String s) {
        int sum = 0;
        if(s.indexOf("IV") != -1) { sum -= 2; }
        if(s.indexOf("IX") != -1) { sum -= 2; }
        if(s.indexOf("XL") != -1) { sum -= 20; }
        if(s.indexOf("XC") != -1) { sum -= 20; }
        if(s.indexOf("CD") != -1) { sum -= 200; }
        if(s.indexOf("CM") != -1) { sum -= 200; }

        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            switch (chs[i]) {
                case 'I': sum += 1; break;
                case 'V': sum += 5; break;
                case 'X': sum += 10; break;
                case 'L': sum += 50; break;
                case 'C': sum += 100; break;
                case 'D': sum += 500; break;
                case 'M': sum += 1000; break;
            }
        }

        return sum;
    }
}
