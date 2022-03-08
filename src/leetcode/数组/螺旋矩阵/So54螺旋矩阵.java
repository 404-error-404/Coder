package leetcode.数组.螺旋矩阵;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/8 15:28
 */
public class So54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int flag = 101;
        // m行n列
        int m = matrix.length;
        int n = matrix[0].length;
        // 结果
        List<Integer> res = new ArrayList<>();
        res.add(matrix[0][0]);
        // 使用 -1 标志已经遍历过
        matrix[0][0] = flag;
        // 方向
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        // xy标志当前坐标，next标志下一位
        int x = 0, y = 0, nextX, nextY;
        for (int i = 1; i < m * n; i++) {
            nextX = x + direction[directionIndex][0];
            nextY = y + direction[directionIndex][1];
            while (nextX == -1 || nextY == -1 || nextX == m || nextY == n || matrix[nextX][nextY] == flag) {
                directionIndex = (directionIndex + 1) % 4;
                nextX = x + direction[directionIndex][0];
                nextY = y + direction[directionIndex][1];
            }
            x = nextX;
            y = nextY;
            res.add(matrix[x][y]);
            matrix[x][y] = flag;
        }
        return res;
    }

    @Test
    public void test() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(spiralOrder(matrix));
    }
}
