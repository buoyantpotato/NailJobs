/**
 * Created by linzhou on 8/15/17.
 */
public class P541_ReverseStr2 {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }

        sol1(s, k);
        return sol2(s, k);
    }

    // Time O(n / 2), Space O(1)  Faster and more concise
    private String sol2(String s, int k) {
        char[] chs = s.toCharArray();
        int i = 0;
        while (i + k - 1 < chs.length) {
            swap(chs, i, i + k - 1);
            i += 2 * k;
        }

        if (i < chs.length) {
            swap(chs, i, chs.length - 1);
        }

        return String.valueOf(chs);
    }

    // Time O(n), Space O(1)
    private String sol1(String s, int k) {
        char[] chs = s.toCharArray();
        int i = 0;
        boolean flag = true;
        while (i + k - 1 < chs.length) {
            if (flag) {
                swap(chs, i, i + k - 1);
                i += k;
                flag = false;
            } else {
                i += k;
                flag = true;
            }
        }

        if (flag) {
            swap(chs, i, chs.length - 1);
        }

        return String.valueOf(chs);
    }

    private void swap(char[] chs, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
    }
}
