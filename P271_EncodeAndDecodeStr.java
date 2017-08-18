import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhou on 8/16/17.
 */
public class P271_EncodeAndDecodeStr {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.size() == 0) {
            return sb.toString();
        }

        for (String str : strs) {
            int len = str.length();
            sb.append(len).append('-').append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        int i = 0;
        while (i < s.length()) {
            int separator = s.indexOf("-", i);
            int len = Integer.parseInt(s.substring(i, separator));
            res.add(s.substring(separator + 1, separator + 1 + len));
            i = separator + len + 1;
        }

        return res;
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(strs));
}
