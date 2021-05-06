package pat;

import java.util.Scanner;


public class So1001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		int num = 0;
		while (n != 1) {
			if (n % 2 == 1) {
				n = 3*n +1;
			}
			n /= 2;
			num++;
		}
		System.out.print(num);
	}
}
