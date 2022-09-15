package leetcode.动态规划;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/15 15:57
 */
public class So279完全平方数 {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int tmp = 1;
        while (tmp * tmp <= n) {
            squares.add(tmp * tmp);
            tmp++;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 99) {
                System.out.println();
            }
            for (Integer square : squares) {
                if (square > i) {
                    break;
                }
                if (dp[i - square] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - square] + 1);
                }
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(
            numSquares(99)
        );
    }
}
