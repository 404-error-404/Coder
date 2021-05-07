package pat;

import java.util.Scanner;

public class So1011 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		boolean[] res = new boolean[t];
		Long a, b, c;
		for(int i = 0; i < t; i++) {
			a = scanner.nextLong();
			b = scanner.nextLong();
			c = scanner.nextLong();
			if(a + b > c) {
				res[i] = true; 
			}
		}
		scanner.close();
		for(int i = 0; i < t; i++) {
			System.out.print("Case #");
			System.out.print(i+1);
			System.out.print(": ");
			System.out.println(res[i]);
		}
	}
}
