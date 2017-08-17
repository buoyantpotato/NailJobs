/**
 * Created by linzhou on 8/16/17.
 */
public class P043_MultiplyString {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0
                || num2 == null || num2.length() == 0) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }

        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        int [] res = new int[chs1.length + chs2.length]; // reverse order
        for (int j = chs2.length - 1; j >= 0; j--) {
            for (int i = chs1.length - 1; i >= 0; i--) {
                int resIndex = chs1.length + chs2.length - 2 - i - j;
                res[resIndex] += (chs1[i] - 48) * (chs2[j] - 48);
            }
        }

        int last = res.length - 1;
        while (last > 0 && res[last] == 0) {
            last--;
        }
        StringBuilder sb = new StringBuilder();
        int buffer = 0;
        for (int i = 0; i <= last; i++) {
            res[i] += buffer;
            sb.append(res[i] % 10);
            buffer = res[i] / 10;
        }
        if (buffer != 0) {
            sb.append(buffer);
        }

        return sb.reverse().toString();
    }
}
