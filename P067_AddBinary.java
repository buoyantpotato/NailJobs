/**
 * Created by linzhou on 8/15/17.
 */
public class P067_AddBinary {
    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        char[] chsLong = a.length() >= b.length() ?
                a.toCharArray() : b.toCharArray();
        char[] chsShort = a.length() < b.length() ?
                a.toCharArray() : b.toCharArray();
        char[] res = new char[chsLong.length];
        int buffer = 0;
        for (int i = chsLong.length - 1, j = chsShort.length - 1; i >= 0; i--, j--) {
            int numA = chsLong[i] - 48;
            int numB = j >= 0 ? chsShort[j] - 48 : 0;
            int temp = numA + numB + buffer;
            res[i] = temp >= 2 ? temp == 3 ? '1' : '0' : (char) (temp + 48);
            buffer = temp >= 2 ? 1 : 0;
        }

        return buffer == 0 ? String.valueOf(res) : "1" + String.valueOf(res);
    }
}
