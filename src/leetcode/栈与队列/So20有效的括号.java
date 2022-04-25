package leetcode.栈与队列;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/valid-parentheses">https://leetcode-cn.com/problems/valid-parentheses</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/22 23:16
 **/
public class So20有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c){
                case ')':
                    if (stack.empty()) {
                        return false;
                    }
                    if (stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty()) {
                        return false;
                    }
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty()) {
                        return false;
                    }
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }
        return stack.empty();
    }

    @Test
    public void test(){
        String s = "";
        assert isValid(s);
    }
}
