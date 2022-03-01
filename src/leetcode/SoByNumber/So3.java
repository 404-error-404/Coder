package leetcode.SoByNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/9/17 12:07
 */
public class So3 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        // 结果
        int res = 0;
        // 临时长度
        int temp = 0;
        for (int i = 0; i < chars.length; i++){
            // 获取上次出现位置（从1开始）并更新当前位置
            int lastIndex = map.getOrDefault(chars[i], 0);
            map.put(chars[i], i+1);
            if (lastIndex < i+1-temp){
                temp++;
            }
            else {
                res = Math.max(temp, res);
                temp = i+1 - lastIndex;
            }
        }
        return Math.max(temp, res);
    }

    public static void main(String[] args) {
        String s = "safjhafiwuah as fsdf asdf sadfds1af5d2 1fas2d fas";
        System.out.println(new So3().lengthOfLongestSubstring(s));
    }
}
