package alibaba;

import java.util.Scanner;

/**
 * 回文串问题
 * 先输入n，接下来会输入n行数据
 * 然后每一行，先输入一个字符串，再输入一个k
 * 对这个字符串每次改动可以改成任意一个小写字母，问最小改动多少次可以分割成k个回文串
 * 比如aabbcc 3；最后结果要输出0
 * 比如abc 2；最后结果要输出1
 * @author 张佳乐
 * */
public class So02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		// 记录答案
		int[] res = new int[n];
		for(int i = 0; i < n; i++) {
			// 记录答案
			res[i] = min_char(scanner.next(), scanner.nextInt()); 
		}
		// 关闭scanner
		scanner.close();
		// 输出答案
		for(int i: res) {
			System.out.println(i);
		}
	}
	/**
	 * @param s: 待处理中字符串
	 * @param k: 要分割成k个回文串
	 * @return 把当前字符串分割为k个回文串所需要的最小修改次数
	 * */
	public static int min_char(String s, int k) {
		return 0;
	}
}
