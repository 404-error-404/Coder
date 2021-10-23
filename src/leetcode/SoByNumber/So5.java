package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

/**
 * @author 张佳乐
 * @date 2021/9/26 20:24
 **/
public class So5 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2){
            return s;
        }
        int maxLen = 1, begin = 0;
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 1; i < chars.length; i++){
            dp[i][i] = true;
        }
        // 先枚举子串长度
        for (int L = 2; L <= chars.length; L++){
            for (int i = 0; i < chars.length; i++){
                // 右边界
                int j = i + L - 1;
                if (j >= chars.length){
                    break;
                }
                else if(chars[i] == chars[j]) {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    int temp = j-i+1;
                    if (dp[i][j] && temp > maxLen){
                        maxLen = temp;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }

    @Test
    public void testLongestPalindrome(){
        String s = "AAAA";
        System.out.println(
                longestPalindrome(s)
        );
    }
}
