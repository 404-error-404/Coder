package leetcode.So04;

public class So0410 {
	public static void main(String[] args) {
		int n = -100;
		if(n < 0) {
			n = -1 * n;
		}
		while(n != 0) {
			if(n == 1) {
				System.out.print(true);
				return;
			}
			else if(n % 2.0 == 0) {
				n /= 2;
			}
			else if(n % 3.0 == 0) {
				n/= 3;
			}
			else if(n % 5.0 == 0) {
				n /= 5;
			}
			else {
				System.out.print(false);
			}
		}
		System.out.print(true);
	}
}
