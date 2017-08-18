import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linzhou on 8/16/17.
 */
public class P249_GroupShiftedString {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }


        // Time O(n * ave(l)), Space O(num of different types);
        Map<String, List<String>> cache = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            char[] chs = strings[i].toCharArray();
            if (chs.length != 0) {
                int dis = chs[0] - 'a';
                for (int j = 0; j < chs.length; j++) {
                    int ascii = chs[j] - dis < 'a' ? chs[j] - dis + 26
                            : chs[j] - dis > 'z' ? chs[j] - dis - 26 : chs[j] - dis;
                    chs[j] = (char) ascii;
                }
            }

            String protoType = new String(chs);
            if (cache.containsKey(protoType)) {
                cache.get(protoType).add(strings[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                cache.put(protoType, list);
                res.add(list);
            }
        }

        return res;
    }
}
