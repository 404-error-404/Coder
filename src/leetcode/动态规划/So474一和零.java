package leetcode.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/13 13:48
 */
public class So474一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int count0 = 0;
            int count1 = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }

            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;

        strs = new String[]{"10", "0", "1"};
        m = 1;
        n = 1;

        System.out.println(
            findMaxForm(strs, m, n)
        );
    }
}
