package leetcode.So05;

/**
 * 在一个小城市里，有m个房子排成一排，你需要给每个房子涂上 n种颜色之一（颜色编号为 1 到 n）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要被重新涂色。
 *
 * 我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区[{1}, {2,2}, {3,3}, {2}, {1,1}] 。）
 *
 * 给你一个数组houses，一个m * n的矩阵cost和一个整数target，其中：
 *
 * houses[i]：是第i个房子的颜色，0表示这个房子还没有被涂色。
 * cost[i][j]：是将第i个房子涂成颜色j+1的花费。
 * 请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成target个街区。如果没有可用的涂色方案，请返回-1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paint-house-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/5/4 14:31
 **/
public class So0504 {
    /**
     * 定义无效值
     * 用来表示房子不可染色时的结果
     */
    final int INF = 0x3f3f3f3f;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] f = new int[m + 1][n + 1][target + 1];

        // 不存在分区数量为 0 的状态
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j][0] = INF;
            }
        }

        for (int i = 1; i <= m; i++) {
            int color = houses[i - 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= target; k++) {
                    // 形成分区数量大于房子数量，状态无效
                    if (k > i) {
                        f[i][j][k] = INF;
                        continue;
                    }

                    // 第 i 间房间已经上色
                    if (color != 0) {
                        // 只有与「本来的颜色」相同的状态才允许被转移
                        if (j == color) {
                            int tmp = INF;
                            // 先从所有「第 i 间房形成新分区」方案中选最优（即与上一房间颜色不同）
                            for (int p = 1; p <= n; p++) {
                                if (p != j) {
                                    tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                                }
                            }
                            // 再结合「第 i 间房不形成新分区」方案中选最优（即与上一房间颜色相同）
                            f[i][j][k] = Math.min(f[i - 1][j][k], tmp);

                        } else { // 其余状态无效
                            f[i][j][k] = INF;
                        }

                        // 第 i 间房间尚未上色
                    } else {
                        int u = cost[i - 1][j - 1];
                        int tmp = INF;
                        // 先从所有「第 i 间房形成新分区」方案中选最优（即与上一房间颜色不同）
                        for (int p = 1; p <= n; p++) {
                            if (p != j) {
                                tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                            }
                        }
                        // 再结合「第 i 间房不形成新分区」方案中选最优（即与上一房间颜色相同）
                        // 并将「上色成本」添加进去
                        f[i][j][k] = Math.min(tmp, f[i - 1][j][k]) + u;
                    }
                }
            }
        }

        // 从「考虑所有房间，并且形成分区数量为 t」的所有方案中找答案
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, f[m][i][target]);
        }
        return ans == INF ? -1 : ans;
    }
//    不会写
//    作者：AC_OIer
//    链接：https://leetcode-cn.com/problems/paint-house-iii/solution/gong-shui-san-xie-san-wei-dong-tai-gui-h-ud7m/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
