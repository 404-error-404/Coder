package leetcode.SoByNumber;

import java.util.HashMap;
import java.util.Map;

public class So_3 {
	public static void main(String[] args) {
		System.out.print(lengthOfLongestSubstring("abcabcbb"));
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	int len = s.length();
    	if(len < 2) {
    		return len;
    	}
    	// 使用map记录当前字符上次出现的位置
    	Map<Character, Integer>char_map = new HashMap<>();
    	int[] max_len_arr = new int[len];	// 记录到当前字符为止的最长子串长度
    	
    	// 使用第一个字符初始化数组和map
    	max_len_arr[0] = 1;
    	char_map.put(s.charAt(0), 0);
    	int max = 1;		// 待返回最大值
    	
    	for(int i = 1; i < len; i++) {
    		char c_now = s.charAt(i);
			// 如果上次出现过，就直接比较前一个无重复子串的起始下标和当前字符上次出现位置
    		if(char_map.containsKey(c_now) && (i - max_len_arr[i-1]) <= char_map.get(c_now)) {
				max_len_arr[i] = i - char_map.get(c_now);
    		}
    		else {
    			max_len_arr[i] = max_len_arr[i-1] + 1; 
			}
    		max = Math.max(max, max_len_arr[i]);
    		char_map.put(c_now, i);
    	}
    	return max;

    }
}
