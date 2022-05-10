package leetcode.字符串.反转字符串;

import org.junit.jupiter.api.Test;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/12 18:44
 **/
public class So541反转字符串Ⅱ {
    public void reverseString(char[] s, int left, int right) {
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0, right;
        while (left < chars.length) {
            right = left + k - 1;
            // 判断剩下字符串个数，以确定要反转的范围
            if (right > chars.length - 1) {
                right = chars.length - 1;
            }
            reverseString(chars, left, right);
            left = right + k + 1;
        }
        return new String(chars);
    }

    @Test
    public void test() {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
