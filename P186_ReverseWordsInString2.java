/**
 * Created by linzhou on 8/16/17.
 */
public class P186_ReverseWordsInString2 {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        // Time O(3n)~O(n), Space O(1);
        swap(s, 0, s.length - 1);

        int i = 0, j = 0;
        while (i < s.length) {
            while (i < s.length && s[i] != ' ') {
                i++;
            }
            swap(s, j, i - 1);
            j = ++i;
        }
    }

    private void swap(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
