/**
 * Created by linzhou on 8/14/17.
 */
public class P161_OneEditDist {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if ((s == null && t != null) || (s != null && t == null)
                || Math.abs(s.length() - t.length()) >= 2) {
            return false;
        }

        sol1(s, t);
        return sol2(s, t);
    }

    // Time O(n)   Fast but long
    private boolean sol1(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int count = 0;
        if (chs.length == cht.length) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] != cht[i]) {
                    count++;
                }
            }
        } else {
            int i = 0, j = 0;
            for (; i < chs.length && j < cht.length; i++, j++) {
                if (chs[i] != cht[j]) {
                    count++;
                    if (chs.length > cht.length) {
                        j--;
                    } else {
                        i--;
                    }
                }
            }
            count += Math.abs((chs.length - 1 - i) - (cht.length - 1 - j));
        }

        return count == 1;
    }

    // Time O(n)   Slower but short
    private boolean sol2(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int count = 0, sBuffer = 0, tBuffer = 0;
        for (int i = 0; i < Math.min(chs.length, cht.length); i++) {
            if (chs[i + sBuffer] != cht[i + tBuffer]) {
                count++;
                if (chs.length > cht.length) {
                    sBuffer++;
                    i--;
                } else if (chs.length < cht.length) {
                    tBuffer++;
                    i--;
                }
            }
            if (count >= 2) {
                return false;
            }
        }

        return (Math.abs(chs.length - cht.length) == 1)
                || (chs.length == cht.length && count == 1);
    }

    // Time O(n)  Slower but shortest
    private boolean sol3(String s, String t) {
        int len = Math.min(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        return Math.abs(s.length() - t.length()) == 1;
    }
}
