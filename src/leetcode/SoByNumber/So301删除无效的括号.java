package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * <p>
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/10/4 16:48
 */
public class So301删除无效的括号 {
    List<String> res;
    static char LEFT = '(', RIGHT = ')';

    public List<String> removeInvalidParentheses(String s) {
        res = new ArrayList<>();
        char[] chars = s.toCharArray();
        int leftRemove = 0, rightRemove = 0;
        for (char c : chars) {
            if (c == LEFT) {
                leftRemove++;
            } else if (c == RIGHT) {
                if (leftRemove == 0) {
                    rightRemove++;
                } else {
                    leftRemove--;
                }
            }
        }
        int left = 0;
        while (left < chars.length && chars[left] == RIGHT) {
            left++;
        }
        int right = chars.length - 1;
        while (right >= 0 && chars[right] == LEFT) {
            right--;
        }
        leftRemove -= chars.length - right - 1;
        rightRemove -= left;
        chars = Arrays.copyOfRange(chars, left, right + 1);
        backtracking(new String(chars), 0, leftRemove, rightRemove);
        return res;
    }

    public void backtracking(String s, int idx, int left, int right) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        if (idx == s.length()) {
            return;
        }
        String s1 = s.substring(0, idx) + s.substring(idx + 1);
        if (s.charAt(idx) == LEFT && (idx == 0 || s.charAt(idx - 1) != LEFT)) {
            if (left != 0) {
                backtracking(s1, idx, left - 1, right);
            }
        } else if (s.charAt(idx) == RIGHT && (idx == 0 || s.charAt(idx - 1) != RIGHT)) {
            if (right != 0) {
                backtracking(s1, idx, left, right - 1);
            }
        }
        backtracking(s, idx + 1, left, right);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == LEFT) {
                stack.add(c);
            } else if (c == RIGHT) {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    @Test
    public void test() {
        List<String> strings = removeInvalidParentheses(")d))");
        System.out.println(strings);
    }
}
