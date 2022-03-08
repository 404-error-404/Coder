package leetcode.So2021.So04;

/**
 * @author WHU-LiXiaoJian
 */
public class So0420 {
    public static int strStr(String haystack, String needle) {
    	if(needle.length() == 0) {
    		return 0;
    	}
    	int len_h = haystack.length();
    	int len_n = needle.length();
    	int[] kmp = new int[len_n];
    	// 构造KMP的next数组
    	for(int i = 1, j = 0; i < len_n; i++) {
    		while(j > 0 && needle.charAt(i) != needle.charAt(j)) {
    			j = kmp[j-1];
    		}
    		if(needle.charAt(i) == needle.charAt(j)) {
    			j++;
    		}
    		kmp[i]= j; 
    	}
    	
    	// 开始匹配
    	for(int i = 0, j = 0; i < len_h; i++) {
    		while(j > 0 && haystack.charAt(i) != needle.charAt(j)) {
    			j = kmp[j-1];
    		}
    		if(haystack.charAt(i) == needle.charAt(j)) {
    			j++;
    		}
    		if(j == len_n) {
    			return i-len_n+1;
    		}
    	}
    	return -1;
    }
    
    public static void main(String[] args) {
		System.out.print(
					strStr("aabbcc", "aa")
				);
	}
}
