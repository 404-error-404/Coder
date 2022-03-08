package leetcode.数组.螺旋矩阵;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/8 12:16
 */
public class So59螺旋矩阵Ⅱ {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 初始位置
        int x = 0, y = 0;
        res[x][y] = 1;
        // 方向，分别表示右下左上
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int nextDirection = 0;
        for (int i = 2; i <= n * n; i++) {
            // 计算下一个
            int nextX = x + direction[nextDirection][0];
            int nextY = y + direction[nextDirection][1];
            while (nextX == -1 || nextY == -1 || nextX == n || nextY == n || res[nextX][nextY] != 0) {
                nextDirection = (nextDirection + 1) % 4;
                nextX = x + direction[nextDirection][0];
                nextY = y + direction[nextDirection][1];
            }
            x = nextX;
            y = nextY;
            res[x][y] = i;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(generateMatrix(5)));
    }
}
