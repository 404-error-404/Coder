package leetcode.回溯;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 1. 数字 1-9 在每一行只能出现一次。
 * 2. 数字 1-9 在每一列只能出现一次。
 * 3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/10 23:04
 **/
public class So37数独解 {
    int boardLen = 9;
    // 要填充的元素
    char[] item = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    // 每行已经有的元素
    boolean[][] itemRow;
    // 每列已有元素
    boolean[][] itemCol;
    // 每9个块已有元素
    boolean[][] item9;

    public boolean backtracking(int x, int y, char[][] board) {
        // 到达最后一个值
        if (x == boardLen && y == 0) {
            return true;
        }
        if (x >= boardLen || y >= boardLen) {
            return false;
        }

        // 当前位置有默认值
        if (board[x][y] != '.') {
            if (y == boardLen - 1) {
                return backtracking(x + 1, 0, board);
            } else {
                return backtracking(x, y + 1, board);
            }
        }

        for (char c : item) {
            int cVal = c - '0';
            int chunk = x / 3 * 3 + y / 3;
            if (itemRow[x][cVal] || itemCol[y][cVal] || item9[chunk][cVal]) {
                continue;
            }
            itemRow[x][cVal] = true;
            itemCol[y][cVal] = true;
            item9[chunk][cVal] = true;
            board[x][y] = c;

            if (y == boardLen - 1) {
                if (backtracking(x + 1, 0, board)) {
                    return true;
                }
            } else {
                if (backtracking(x, y + 1, board)) {
                    return true;
                }
            }

            itemRow[x][cVal] = false;
            itemCol[y][cVal] = false;
            item9[chunk][cVal] = false;
            board[x][y] = '.';
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        itemRow = new boolean[boardLen][10];
        itemCol = new boolean[boardLen][10];
        item9 = new boolean[boardLen][10];

        for (int x = 0; x < boardLen; x++) {
            for (int y = 0; y < boardLen; y++) {
                if (board[x][y] != '.') {
                    int cVal = board[x][y] - '0';
                    int chunk = x / 3 * 3 + y / 3;
                    itemRow[x][cVal] = true;
                    itemCol[y][cVal] = true;
                    item9[chunk][cVal] = true;
                }
            }
        }

        backtracking(0, 0, board);
    }


    @Test
    public void test() {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
