package leetcode.So2021.So03;


/**
 * @author WHU-LiXiaoJian
 */
public class So0330 {
    // 记录目标值得最终行
    public static int pos = 0;

    public static void main(String[] args) {
		int[][] arr;
		arr = new int[][] {
			{1, 3, 5, 7},
			{10, 11, 16, 20},
			{23, 30, 34, 60}
		};		
		System.out.print(searchMatrix(arr, 8));
	}
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 先对第一列折半查找，找到所在行
        // 再对这一行进行折半查找以找到所在列
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 先判断是否存在
        if(target > matrix[rows-1][cols-1] || target < matrix[0][0]){
            return false;
        }
        // 判断是否在最后一行，是则直接标记，不是则二分搜索
        if(target > matrix[rows-1][0]){
            pos = rows - 1;
        }
        else if(target == matrix[rows-1][0]){
            return true;
        }
        else{
            if(searchRow(matrix, target, 0, rows-1)){
                return true;
            }
        }

        return searchCol(matrix, target, 0, cols-1);
        
    }

    static boolean searchRow(int[][] matrix, int target, int minRow, int maxRow){
        // *** 需要保证，目标值在第一行到最后一行中间（不包含最后一行）
        // 寻找所在行
        if(maxRow - minRow == 1){
            pos = minRow;
            return false;
        }

        int mid = (maxRow + minRow) / 2;
        if(matrix[mid][0] == target) {
            return true;
        }
        if(matrix[mid][0] > target){
            return searchRow(matrix, target, minRow, mid);
        }
        else{
            return searchRow(matrix, target, mid, maxRow);
        }
    }

    static boolean searchCol(int[][] matrix, int target, int minCol, int maxCol){
        if(target == matrix[pos][minCol] || target == matrix[pos][maxCol]){
            return true;
        }

        if(target > matrix[pos][maxCol] || (maxCol - minCol) == 1){
            return false;
        }

    
        int mid = (minCol + maxCol) / 2;
        if(target > matrix[pos][mid]){
            return searchCol(matrix, target, mid, maxCol);
        }
        else if(target == matrix[pos][mid]){
            return true;
        }
        else{
            return searchCol(matrix, target, minCol, mid);
        }
    }
}
