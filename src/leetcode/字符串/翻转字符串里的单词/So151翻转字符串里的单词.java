package leetcode.字符串.翻转字符串里的单词;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 * <p>
 * 说明：
 * <p>
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/12 20:20
 **/
public class So151翻转字符串里的单词 {
    public String reverseWords(String s) {
        List<String> resList = new ArrayList<>();
        char[] chars = s.toCharArray();
        int left = 0;
        while (left < chars.length && chars[left] == ' ') {
            left++;
        }
        int right = left + 1;
        while (right < chars.length) {
            if (chars[right] == ' ') {
                resList.add(s.substring(left, right));
                while (right < chars.length && chars[right] == ' ') {
                    right++;
                }
                left = right;
            } else {
                right++;
            }
        }
        if (left < chars.length && right == chars.length) {
            resList.add(s.substring(left, right));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = resList.size() - 1; i >= 0; i--) {
            stringBuilder.append(resList.get(i));
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        System.out.println(reverseWords(" the sky is blue"));
    }
}
