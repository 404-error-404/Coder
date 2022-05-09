package leetcode.回溯;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/9 17:22
 */
public class So51N皇后 {
    List<List<String>> res;
    // 检查列
    boolean[] used;
    // 检查45°斜线
    boolean[] used45;
    // 检查135°斜线
    boolean[] used135;
    char[][] grid;

    public void dfs(int n, int idx) {
        if (idx == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] g : grid) {
                tmp.add(String.copyValueOf(g));
            }
            res.add(tmp);
            return;
        }
        for (int i = 0; i < n; i++) {
            int idx45 = idx - i + n - 1;
            int idx135 = idx + i;

            if (used[i] || used45[idx45] || used135[idx135]) {
                continue;
            }
            grid[idx][i] = 'Q';
            used[i] = true;
            used45[idx45] = true;
            used135[idx135] = true;

            dfs(n, idx + 1);

            grid[idx][i] = '.';
            used[i] = false;
            used45[idx45] = false;
            used135[idx135] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        grid = new char[n][n];
        for (char[] g : grid) {
            Arrays.fill(g, '.');
        }
        res = new ArrayList<>();
        used = new boolean[n];
        used45 = new boolean[n * 2 - 1];
        used135 = new boolean[n * 2 - 1];

        dfs(n, 0);

        return res;
    }

    @Test
    public void test() {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists.toString());
    }
}
