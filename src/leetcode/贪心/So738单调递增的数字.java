package leetcode.贪心;

import org.junit.jupiter.api.Test;

/**
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * <p>
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/4 21:28
 **/
public class So738单调递增的数字 {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int start = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) {
                chars[i] = '9';
                chars[i - 1] = (char) (chars[i - 1] - 1);
                start = i;
            }
        }
        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }
        int res = 0;
        for (char i : chars) {
            res = res * 10 + i - '0';
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(monotoneIncreasingDigits(9008));
    }
}
