/**
 * Created by linzhou on 2016/11/29.
 */
public class GG_OA_DashString {
    public static String solution(String str, int k) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '-') {
                sb.append(chars[i]);
                count++;
                if (count == k) {
                    sb.append("-");
                    count = 0;
                }
            }
        }
        chars = sb.toString().toCharArray();
        sb = new StringBuilder();
        int i = chars.length - 1;
        while (chars[i] == '-') {
            i--;
        }
        for (; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(solution("r", 1));
    }
}
