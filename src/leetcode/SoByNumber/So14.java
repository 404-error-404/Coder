package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/9/29 14:20
 */
public class So14 {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0){
            return "";
        }
        int len = strs.length;
        char[][] chars = new char[len][];
        int minStrLen = strs[0].length();
        for (int i = 0; i < len; i++){
            chars[i] = strs[i].toCharArray();
            minStrLen = Math.min(chars[i].length, minStrLen);
        }
        for (int i = 0; i < minStrLen; i++){
            for (int j = 1; j < len; j++){
                if(chars[j][i] != chars[j-1][i]){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minStrLen);
    }

    @Test
    public void test(){
        String[] strs = new String[]{
                "car","","car"
        };
        System.out.println(longestCommonPrefix(strs));
    }
}
