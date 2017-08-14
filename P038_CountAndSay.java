/**
 * Created by linzhou on 8/13/17.
 */
public class P038_CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String str = "1";
        for (int i = 2; i <= n; i++) {
            char[] chs = str.toCharArray();
            StringBuilder sb = new StringBuilder();

            int count = 0;
            char num = '0';
            for (int j = 0; j < chs.length; j++) {
                if (num != chs[j]) {
                    if (num != '0') {
                        sb.append(count).append(num);
                    }
                    num = chs[j];
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(count).append(num);

            str = sb.toString();
        }

        return str;
    }
}
