package leetcode.数组.长度最小的子数组;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/7 15:52
 */
public class So76最小覆盖子串 {
    Map<Character, Integer> curMap;
    Map<Character, Integer> tMap;

    private boolean check() {
        for (Map.Entry<Character, Integer> item : tMap.entrySet()) {
            if (curMap.get(item.getKey()) < item.getValue()) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        tMap = new HashMap<>();
        curMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // 计数t中所包含的字符
        for (char c : tChars) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            curMap.put(c, 0);
        }
        // 滑动窗口
        int left = 0, right = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        while (right <= sChars.length) {
            if (check()) {
                int curLen = right - left;
                if (curLen < minLen) {
                    minLen = curLen;
                    minStart = left;
                }
                char c = sChars[left];
                if (curMap.containsKey(c)) {
                    curMap.put(c, curMap.get(c) - 1);
                }
                left++;
            } else {
                if (right == sChars.length) {
                    break;
                }
                char c = sChars[right];
                if (curMap.containsKey(c)) {
                    curMap.put(c, curMap.get(c) + 1);
                }
                right++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minStart, minStart + minLen);
        }
    }

    @Test
    public void test() {
        System.out.println(minWindow("bba", "ab"));
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
