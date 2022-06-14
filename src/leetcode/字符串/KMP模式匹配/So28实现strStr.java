package leetcode.字符串.KMP模式匹配;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 *
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/13 22:34
 **/
public class So28实现strStr {
    int[] nextArray(String s) {
        int[] next = new int[s.length()];
        if (next.length == 0) {
            return next;
        }

        // 初始化第一位
        next[0] = -1;
        int i = 0, j = -1;
        while (i < next.length - 1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0 || haystack.length() == 0) {
            return -1;
        }
        char[] needleChars = needle.toCharArray();
        // 构造next数组
        int[] next = new int[needleChars.length];
        int j = -1;
        next[0] = j;
        for (int i = 1; i < needleChars.length; i++) {
            while (j >= 0 && needleChars[i] != needleChars[j + 1]) {
                j = next[j];
            }
            if (needleChars[i] == needleChars[j + 1]) {
                j++;
            }
            next[i] = j;
        }
        j = -1;
        char[] s = haystack.toCharArray();
        for (int i = 0; i < s.length; i++) {
            while (j >= 0 && s[i] != next[j + 1]) {
                j = next[j];
            }
            if (s[i] == next[j + 1]) {
                j++;
            }
            if (j == s.length - 1) {
                return i - next.length + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String s = "ABABACD";
        System.out.println(Arrays.toString(nextArray(s)));
    }
}
