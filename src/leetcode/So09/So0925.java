package leetcode.So09;

import org.junit.jupiter.api.Test;

/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/9/25 21:28
 **/
public class So0925 {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int l1 = w1.length, l2 = w2.length;
        int[][] dp = new int[l1+1][l2+1];
        for(int i = 1; i <= l1; i++){
            for (int j = 1; j <= l2; j++){
                if(w1[i-1] == w2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j]  = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return l1 + l2 - dp[l1][l2] *2 ;
    }

    @Test
    public void testMinDistance(){
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(
                minDistance(word1, word2)
        );
    }
}
