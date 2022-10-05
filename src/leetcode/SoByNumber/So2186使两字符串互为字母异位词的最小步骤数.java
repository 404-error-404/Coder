package leetcode.SoByNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s 和 t 。在一步操作中，你可以给 s 或者 t 追加 任一字符 。
 * <p>
 * 返回使 s 和 t 互为 字母异位词 所需的最少步骤数。
 * <p>
 * 字母异位词 指字母相同但是顺序不同（或者相同）的字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/10/5 16:41
 */
public class So2186使两字符串互为字母异位词的最小步骤数 {
    /**
     * 哈希表做法
     */
    public int minSteps2(String s, String t) {
        Map<Character, Integer> countS = new HashMap<>(s.length());
        Map<Character, Integer> countT = new HashMap<>(t.length());

        for (char c : s.toCharArray()) {
            countS.put(c, countS.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        for (char c : countS.keySet()) {
            res += Math.abs(countS.get(c) - countT.getOrDefault(c, 0));
        }
        for (char c : countT.keySet()) {
            if (!countS.containsKey(c)) {
                res += countT.get(c);
            }
        }
        return res;
    }

    /**
     * 数组做法
     */
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        int res = 0;
        for (int i : count) {
            res += Math.abs(i);
        }
        return res;
    }
}
