package leetcode.回溯;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/7 23:51
 **/
public class So93复原IP地址 {
    List<String> res;
    Stack<String> stack;

    public boolean isValid(String s, int start, int end) {
        if (start != end && s.charAt(start) == '0') {
            return false;
        }
        if (end - start > 2) {
            return false;
        }
        return Integer.parseInt(s.substring(start, end + 1)) <= 255;
    }

    public void backtracking(String s, int count, int idx) {
        if (idx == s.length()) {
            return;
        }
        if (count == 4) {
            if (isValid(s, idx, s.length() - 1)) {
                stack.add(s.substring(idx, s.length()));

                StringJoiner stringJoiner = new StringJoiner(".");
                stack.forEach(stringJoiner::add);
                res.add(stringJoiner.toString());

                stack.pop();
            }
            return;
        }

        for (int i = idx; i < s.length() + count - 4; i++) {
            if (isValid(s, idx, i)) {
                stack.add(s.substring(idx, i + 1));

                backtracking(s, count + 1, i + 1);

                stack.pop();
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        stack = new Stack<>();

        backtracking(s, 1, 0);

        return res;
    }

    @Test
    public void test() {
        String s = "1231231231234";
        System.out.println(restoreIpAddresses(s));
    }
}

