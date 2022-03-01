package leetcode.SoByNumber;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/6/13 18:47
 **/
public class So9 {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        String strX = String.valueOf(x);
        int len = strX.length();
        for(int i = 0; i < len / 2; i++){
            if(strX.charAt(i) != strX.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                new So9().isPalindrome(1111111111)
        );
    }
}
