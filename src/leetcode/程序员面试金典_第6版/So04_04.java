package leetcode.程序员面试金典_第6版;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2022/1/24 22:33
 **/
public class So04_04 {
    public boolean canPermutePalindrome(String s) {
        char[] cArr = s.toCharArray();
        Map<Character, Integer> cCount = new HashMap<>();
        for (char c: cArr) {
            cCount.put(c, cCount.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (int count: cCount.values()) {
            odd += count % 2;
        }
        return odd <= 1;
    }

    @Test
    public void testCanPermutePalindrome(){
        System.out.println(canPermutePalindrome("asdjkhk"));
    }
}
