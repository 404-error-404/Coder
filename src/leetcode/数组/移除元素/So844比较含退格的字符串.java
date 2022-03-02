package leetcode.数组.移除元素;

import org.junit.jupiter.api.Test;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * @author 小乐乐
 * @date 2022/3/2 18:57
 **/
public class So844比较含退格的字符串 {
    public String removeBackspace(String s) {
        char[] sChars = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while (fast < sChars.length) {
            if (sChars[fast] == '#') {
                slow--;
                if (slow < 0) {
                    slow = 0;
                }
            } else {
                sChars[slow] = sChars[fast];
                slow++;
            }
            fast++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < slow; i++) {
            res.append(sChars[i]);
        }
        return res.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return removeBackspace(s).equals(removeBackspace(t));
    }

    @Test
    public void test() {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }
}
