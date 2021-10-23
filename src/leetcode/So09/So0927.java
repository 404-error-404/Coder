package leetcode.So09;

import org.junit.Test;

/**
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
 *
 * "AAJF" 对应分组 (1 1 10 6)
 * "KJF" 对应分组 (11 10 6)
 * 注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
 *
 * 除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
 *
 * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
 *
 * 由于答案数目可能非常大，返回对 109 + 7 取余 的结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/9/27 18:02
 */
public class So0927 {
    static final int MOD = 1000000007;

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        long[] dp = new long[chars.length];
        // 初始化第一位
        dp[0] = chars[0] == '*'? 9L: 1L;
        if (chars.length == 1){
            return (int)dp[0];
        }
        // 初始化第二位
        if (ifChar2Bit(chars[0], chars[1])){
            dp[1] = 2L;
            dp[2] = dp[1];
        }
        for (int i = 2; i < chars.length; i++){
            if (chars[i] == '*'){
                dp[i] = dp[i-1] * 9 % MOD;
            }
            else if (ifChar2Bit(chars[i-1], chars[i])){
                dp[i] = dp[i-2] * 2 % MOD;
            }
            else {
                dp[i] = dp[i-1];
            }
        }
        return (int)dp[chars.length-1];
    }

    /**
     * 看着两个字符是否可以构成一个字符
     * 即判断两个字符是否可以构成J或J之后的字符
     * @param c1 第一位字符，只可能是 0-9 或 * 其中一个字符
     * @param c2 第二位字符，只可能是 0-9 或 * 其中一个字符
     * @return 能否构成字符
     */
    public boolean ifChar2Bit(char c1, char c2){
        if (c2 != '*'){
            return c1 == '1' || (c1 == '2' && c2 <= '6');
        }
        return false;
    }

    @Test
    public void testNumDecoding(){
        // 还没做完，吃饭去，回寝室接着磕
        String s = "1*";
        System.out.println(
                numDecodings(s)
        );
    }
}
