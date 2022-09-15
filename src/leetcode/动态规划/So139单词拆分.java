package leetcode.动态规划;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/15 16:17
 */
public class So139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() && s.startsWith(word, i - word.length())) {
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        s = "catsandog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(
            wordBreak(s, wordDict)
        );
    }
}
