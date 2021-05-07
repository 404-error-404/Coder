package pat;

import java.util.Scanner;

public class So1002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		scanner.close();
		
		int len = s.length();
		int sum = 0;
		for(int i = 0; i< len; i++) {
			sum += s.charAt(i) - '0';
		}
		String ss = String.valueOf(sum);
		for(int i = 0; i < ss.length(); i++) {
			switch (ss.charAt(i)) {
				case '0': {
					System.out.print("ling");
					break;
				}
				case '1': {
					System.out.print("yi");
					break;
				}
				case '2': {
					System.out.print("er");
					break;
				}
				case '3': {
					System.out.print("san");
					break;
				}
				case '4': {
					System.out.print("si");
					break;
				}
				case '5': {
					System.out.print("wu");
					break;
				}
				case '6': {
					System.out.print("liu");
					break;
				}
				case '7': {
					System.out.print("qi");
					break;
				}
				case '8': {
					System.out.print("ba");
					break;
				}
				case '9': {
					System.out.print("jiu");
					break;
				}
				default:{}
			}
			if(i != ss.length() - 1) {
				System.out.print(" ");
			}
		}
	}
}
