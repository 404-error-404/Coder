package alibaba;

import java.util.Scanner;

/**
 * 分形
 * 矩阵A1 = [0 1
 *          0 1]
 * 之后的An = [B(n-1) A(n-1)
 *           A(n-1) B(n-1)]
 * 其中B(n)是2^(n-1)阶0矩阵
 * 1 <= n <= 10
 * 输入n，输出对应的矩阵
 * @author 张佳乐
 * */
public class So01 {
	public static void main(String[] args) {
		// An是2^(n-1) * 2^(n-1)矩阵
		// 可以将An分成很多个2*2的小矩阵，在左上方的都是0矩阵
		// 右下方则都是A1

		// 首先获取n
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		// 获取矩阵的阶数
		int col = 2 << (n - 1);
		// 对每一个数进行计算，看是否输出1
		for(int i = 1; i <= col; i++) {
			// 这里对每一行，循环，只输出前 col-1 个数和一个空格
			// 最后一个数不输出空格，单独处理
			for(int j = 1; j < col; j++) {
				// 如果在矩阵左上方位置就输出0
				// 不在左上方但是是单个2*2矩阵的首元素也要输出0
				// 如果是单独的n*n矩阵的左上角的小矩阵也要输出0
				if(i + j <= col || ((i+1)/2%2 == 1 && (j+1)/2%2 == 1) || (i % 2 == 1 && j % 2 == 1)) {
					System.out.print(0);
				}
				else {
					System.out.print(1);
				}
				// 输出空格
				System.out.print(" ");
			}
			// j = col 时输出1
			System.out.println(1);
		}
	}
}