package leetcode.回溯;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/7 16:47
 **/
public class So17电话号码的字母组合 {
    List<String> res;
    Map<Character, char[]> map;
    StringBuilder stringBuilder;

    public void backtracking(char[] digits, int idx) {
        if (idx == digits.length) {
            res.add(stringBuilder.toString());
            return;
        }
        for (char c : map.get(digits[idx])) {
            stringBuilder.append(c);
            backtracking(digits, idx + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if ("".equals(digits)) {
            return res;
        }
        map = new HashMap<Character, char[]>(8);
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        stringBuilder = new StringBuilder();

        backtracking(digits.toCharArray(), 0);
        return res;
    }

    @Test
    public void test() {
        System.out.println(letterCombinations(""));
    }
}
