package nowcoder;

import java.util.Scanner;

// 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。
// 答案可能有多个,我我们需要找出长度最小的那个。
// 例如 N = 18 L = 2:
// 5 + 6 + 7 = 18
// 3 + 4 + 5 + 6 = 18
// 都是满足要求的，但是我们输出更短的567


/**
 * @author 小乐乐
 */
public class SoTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int l = scanner.nextInt();
		scanner.close();
		// 从第i个数开始，连续l个数的和是
		// (i + (i + l -1)) * l  / 2 = n 
		// 即(i + (i + l -1)) * l = n * 2
		// 2*i + l - 1 = 2 * n / l
		int temp = (n * 2 / l + 1 - l) / 2;
		while((temp + (temp + l -1)) * l != n * 2) {
			l++;
			temp = (n * 2 / l + 1 - l) / 2;
		}
		for(int i = 0; i < l; i++) {
			System.out.print(temp++ + " ");
		}
	}
}
