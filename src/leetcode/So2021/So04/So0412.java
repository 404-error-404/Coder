package leetcode.So2021.So04;

import java.util.ArrayList;
import java.util.List;

public class So0412 {
	public static void main(String[] args) {
		// 3 > 30
		// 34 > 30
		// 34 > 3
		String ans = largestNumber(new int[] {111311, 1113});
		System.out.print(ans);
	}
	
    public static String largestNumber(int[] nums) {
    	String res = "";
    	List<String>num_str_list = new ArrayList<>();
    	int list_len = 1;
    	num_str_list.add(String.valueOf(nums[0]));
    	for(int i = 1; i < nums.length; i++) {
    		String num_str = String.valueOf(nums[i]);
    		// 将该字符串插入字符串list中
    		int j = 0;
    		for(; j < list_len; j++) {
    			if(str_cmp(num_str, num_str_list.get(j))){
    				break;
    			}
    		}
    		num_str_list.add(j, num_str);
    		list_len++;
    	}
    	if(num_str_list.get(0).equals("0")) {
    		return "0";
    	}
    	for(String ss: num_str_list) {
    		res += ss;
    	}
    	return res;
    }
    
    public static boolean str_cmp(String s1, String s2) {
    	int len1 = s1.length();
    	int len2 = s2.length();
    	int min_len = Math.min(len1, len2);
    	// 当两个字符串长度相等时直接比较
    	// 当两个字符串前min_len子串相等时也直接比较
    	if(len1 == len2 || !s1.substring(0, min_len).equals(s2.substring(0, min_len))) {
    		return s1.compareTo(s2) > 0;
    	}
    	// 否则，比较较长字符串剩下部分子串和较短字符串开始部分
    	if(len1 == min_len) {
    		return str_cmp(s1, s2.substring(min_len));
    	}
    	else {
    		return str_cmp(s1.substring(min_len), s2);
    	}
	}
}
