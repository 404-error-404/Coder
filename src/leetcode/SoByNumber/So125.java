package leetcode.SoByNumber;

public class So125 {
	public static void main(String[] args) {
		boolean sx =isPalindrome("A man, 9a plan, a canal: Pa9nama");
		System.out.print(sx);
	}
	
	public static boolean isPalindrome(String s) {
        s = s.toUpperCase();
        int len = s.length();
        int begin = 0;
        int end = len-1;
        while(begin < end) {
        	if(!isCharOrNum(s.charAt(begin))) {
        		begin++;
        	}
        	else if (!isCharOrNum(s.charAt(end))) {
				end--;
			}
        	else if (s.charAt(begin) == s.charAt(end)) {
				begin++;
				end--;
			}
        	else {
				return false;
			}
        }
        return true;
    }
	
	public static boolean isCharOrNum(Character c) {
		if(c <= 'Z' && c >= 'A') {
			return true;
		}
		return c >= '0' && c <= '9';
	}
}
