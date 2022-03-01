package leetcode.程序员面试金典_第6版;

import org.junit.jupiter.api.Test;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2022/1/25 22:26
 **/
public class So01_05 {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        // 短的和长的字符串
        char[] c1, c2;
        // 记录长度差
        int dif;
        if (len1 > len2) {
            c1 = second.toCharArray();
            c2 = first.toCharArray();
            dif = len1 - len2;
        }
        else {
            c2 = second.toCharArray();
            c1 = first.toCharArray();
            dif = len2 - len1;
        }
        if (dif > 1) {
            return false;
        }

        // 遍历长短字符串，找出不一样的位置
        int index1 = 0, index2 = 0, countDif = 0;
        for (;index1 < c1.length && index2 < c2.length; index1++, index2++) {
            if (c1[index1] != c2[index2]) {
                countDif++;
                if (countDif > 1) {
                    return false;
                }
                // 长度差为1：短字符串插入字符得到长字符串,否则是替换字符
                if (dif == 1) {
                    index1--;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(oneEditAway("", "a"));
    }
}
