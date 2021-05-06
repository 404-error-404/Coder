package leetcode.So03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
