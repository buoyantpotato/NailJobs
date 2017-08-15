import java.util.Stack;

/**
 * Created by linzhou on 8/14/17.
 */
public class P227_BasicCalculator2 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> nums = new Stack<>();
        char sign = '+';
        char[] chs = s.toCharArray();
        int res = 0, num = 0;
        for (int i = 0; i < chs.length; i++) {
            switch (chs[i]) {
                case '+': case '-': case '*': case '/':
                    sign = chs[i];
                    break;
                case ' ':
                    break;
                default:
                    num = num * 10 + chs[i] - 48;
                    if (i + 1 < chs.length && !Character.isDigit(chs[i + 1]) || i + 1 >= chs.length) {
                        switch (sign) {
                            case '*':
                                nums.push(nums.pop() * num);
                                break;
                            case '/':
                                nums.push(nums.pop() / num);
                                break;
                            case '-':
                                nums.push(-num);
                                break;
                            default:
                                nums.push(num);
                                break;
                        }
                        num = 0;
                    }
                    break;
            }
        }

        while (!nums.isEmpty()) {
            res += nums.pop();
        }

        return res;
    }
}
