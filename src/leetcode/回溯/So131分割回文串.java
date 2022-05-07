package leetcode.回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/7 23:31
 **/
public class So131分割回文串 {
    List<List<String>> res;
    Stack<String> stack;


    public boolean isPartition(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public void backtracking(String s, int idx) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPartition(s, idx, i)) {
                stack.add(s.substring(idx, i + 1));

                backtracking(s, i + 1);

                stack.pop();
            }
        }

    }

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        stack = new Stack<>();

        backtracking(s, 0);

        return res;
    }
}
