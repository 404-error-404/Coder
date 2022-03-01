package leetcode.数组.二分查找;

import org.junit.jupiter.api.Test;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/1 17:59
 */
public class So367有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square > num) {
                right = mid - 1;
            } else if (square == num) {
                return true;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(isPerfectSquare(1));
    }
}
