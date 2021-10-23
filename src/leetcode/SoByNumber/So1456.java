package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * 1456. 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * @author 小乐乐
 * @date 2021/10/23 11:00
 */
public class So1456 {
    public int isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1: 0;
    }

    public int maxVowels(String s, int k) {
        int res = 0;
        for (int i=0; i < k; i++){
            res += isVowel(s.charAt(i));
        }
        int temp = res;
        for (int i = k; i < s.length(); i++){
            temp += isVowel(s.charAt(i)) - isVowel(s.charAt(i-k));
            res = Math.max(temp, res);
        }
        return res;
    }

    @Test
    public void maxVowelsTest(){
        String s = "abciriiderf";
        int k = 3;
        System.out.println(maxVowels(s,  k));
    }
}