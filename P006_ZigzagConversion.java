/**
 * Created by linzhou on 8/16/17.
 */
public class P006_ZigzagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }

        return sol1(s, numRows);
    }

    // Time O(n), Space O(n);
    private String sol1(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        int dis = numRows * 2 - 2;
        int numGroup = chs.length / dis + 1;
        for (int i = 0; i < dis / 2 + 1; i++) {
            for (int j = 0; j <= numGroup; j++) {
                int headIndex = j * dis + i;
                int tailIndex = j * dis + (dis - i);
                String head = headIndex < chs.length ? String.valueOf(chs[headIndex]) : "";
                String tail = tailIndex < chs.length && tailIndex < (j + 1) * dis
                        && tailIndex != headIndex ? String.valueOf(chs[tailIndex]) : "";
                sb.append(head).append(tail);
            }
        }

        return sb.toString();
    }


}
