import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhou on 8/15/17.
 */
public class P616_AddBoldTaginStr {

    public String addBoldTag(String s, String[] dict) {
        if (s == null || dict == null) {
            return "";
        }

        sol1(s, dict);
        return sol2(s, dict);
    }

    // s.length = n, dict.size() = m, averageLenOfWordInDict = l
    // Time O(m * n * l), Space O(n)   Faster and shorter
    private String sol2(String s, String[] dict) {
        boolean[] flag = new boolean[s.length()];
        char[] chs = s.toCharArray();
        for (String word : dict) {
            int i = -1;
            while ((i = s.indexOf(word, i + 1)) >= 0) {   // Good Code !!!!
                for (int j = 0; j < word.length(); j++) {
                    flag[i + j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < flag.length) {
            if (flag[i]) {
                sb.append("<b>");
                while (i < flag.length && flag[i]) {
                    sb.append(chs[i]);
                    i++;
                }
                sb.append("</b>");
            } else {
                while (i < flag.length && !flag[i]) {
                    sb.append(chs[i]);
                    i++;
                }
            }
        }

        return sb.toString();
    }


    // Time O(m*m*l || m*n*l), Space O(m || n)
    private String sol1(String s, String[] dict) {
        boolean[] flag = new boolean[s.length()];
        char[] chs = s.toCharArray();
        for (String word : dict) {
            List<Integer> list = getBeginIndex(chs, word);
            if (list.size() != 0) {
                for (Integer i : list) {
                    for (int j = 0; j < word.length(); j++) {
                        flag[i + j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < flag.length) {
            if (flag[i]) {
                sb.append("<b>");
                while (i < flag.length && flag[i]) {
                    sb.append(chs[i]);
                    i++;
                }
                sb.append("</b>");
            } else {
                while (i < flag.length && !flag[i]) {
                    sb.append(chs[i]);
                    i++;
                }
            }
        }

        return sb.toString();
    }

    private List<Integer> getBeginIndex(char[] chs, String word) {
        List list = new ArrayList<>();
        char[] w = word.toCharArray();
        for (int i = 0; i <= chs.length - w.length; i++) {
            if (chs[i] == w[0]) {
                for (int j = 0; j < w.length; j++) {
                    if (chs[i + j] != w[j]) {
                        break;
                    }
                    if (chs[i + j] == w[j] && j + 1 == w.length) {
                        list.add(i);
                    }
                }
            }
        }

        return list;
    }
}
