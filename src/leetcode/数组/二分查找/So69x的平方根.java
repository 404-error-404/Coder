package leetcode.数组.二分查找;

import org.junit.jupiter.api.Test;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/1 17:57
 */
public class So69x的平方根 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = x;
        int mid;

        while (right - left > 1) {
            mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    @Test
    public void test() {
        System.out.println(mySqrt(1));
    }
}
