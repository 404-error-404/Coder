package leetcode.哈希表.有效的字幕异位词;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/11 0:39
 **/
public class So438找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 比较的基准
        char[] base = p.toCharArray();
        int baseLen = base.length;
        Arrays.sort(base);

        char[] chars = s.toCharArray();
        if (chars.length < base.length) {
            return res;
        }

        char[] temp;
        for (int i = 0; i <= chars.length - baseLen; i++) {
            temp = Arrays.copyOfRange(chars, i, i + baseLen);
            Arrays.sort(temp);
            if (Arrays.equals(base, temp)){
                res.add(i);
            }
        }
        return res;
    }

    @Test
    public void test() {
        char[] a = {1, 2, 3};
        char[] s = new char[3];
        s[0] = 1;
        s[1] = 2;
        s[2] = 3;
        System.out.println(Arrays.equals(s, a));
    }
}
