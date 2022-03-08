package leetcode.So2021.So03;

public class So0329 {
	public static void main(String[] args) {
		int s = 7;
		// s = -536870912;
		int res = 0;
		for(int i = 0; i < 32; i++) {
			res <<= 1;
			System.out.print(s&1);
			res += s & 1;
			s >>>= 1;
		}
		System.out.print(res);
	}
}
