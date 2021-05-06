package pat;

import java.util.Scanner;

public class So1048 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		String b = scanner.next();
		scanner.close();
		StringBuilder res = new StringBuilder();
		
		int a_len = a.length();
		int b_len = b.length();
		int min_len = Math.min(a_len, b_len);
		// 先对奇数位操作，再对偶数位操作
		for(int i = 1; i <= min_len; i++) {
			// 从最右边开始
			int a_val = a.charAt(a_len - i) - '0';
			int b_val = b.charAt(b_len - i) - '0';
			int tem;	// 暂存当前位的计算结果
			if (i % 2 == 1) {
				tem = (a_val + b_val) % 13;
			}
			else {
				tem = b_val - a_val;
				if (tem < 0) {
					tem += 10;
				}
			}
				
			char c = '0';	// 将当前位转换为字符
			if (tem > 9) {
				switch (tem){
					case 10: {
						c = 'J';
						break;
					}
					case 11: {
						c = 'Q';
						break;
					}
					case 12: {
						c = 'K';
						break;
					}
				}
			}
			else {
				c = (char) ('0' + tem);
			}
			res.insert(0, String.valueOf(c));
		}
		if (min_len < b_len) {
			res.insert(0, b.substring(0, b_len - min_len));
		}
		System.out.print(res);		
	}
}
