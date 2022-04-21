package leetcode.双指针法.移除元素;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/backspace-string-compare">https://leetcode-cn.com/problems/backspace-string-compare</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/18 21:32
 **/
public class So844比较含退格的字符串 {
    private Stack<Character> strToStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
        }
        return stack;
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = strToStack(s);
        Stack<Character> stackT = strToStack(t);

        while (!stackS.empty() && !stackT.empty()) {
            if (!stackS.pop().equals(stackT.pop())) {
                return false;
            }
        }
        return stackS.empty() && stackT.empty();
    }

    @Test
    public void test() {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }
}
