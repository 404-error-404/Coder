package leetcode.面试题;

import org.junit.jupiter.api.Test;

/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
 * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2022/1/17 22:17
 **/
public class So16_18 {
    public boolean patternMatching(String pattern, String value) {
        // 如果不是a开头就将a和b互换
        if (pattern.charAt(0) == 'b') {
            pattern = pattern.replace('a', 'c').replace('b', 'a').replace('c', 'b');
        }

        String a, b;
        int lenA = 0, lenB = 0, countA = 0, countB = 0;
        int valueLen = value.length();

        // 计数模式串中a和b的出现次数
        for (char c : pattern.toCharArray()) {
            if (c == 'a') {
                countA++;
            } else {
                countB++;
            }
        }

        if (value.length() == 0) {
            return (countA == 0 || countB == 0) && countA + countB != 0;
        }

        if (countA == 0 || countB == 0) {
            lenA = valueLen / pattern.length();
            a = value.substring(0, lenA);
            if (countA == 0) {
                pattern = pattern.replace("b", a);
            } else {
                pattern = pattern.replace("a", a);
            }
            return value.equals(pattern);
        }

        // a从空字符串开始尝试
        while (lenB >= 0 && lenA <= valueLen) {
            // 计算a和b
            a = value.substring(0, lenA);
            lenB = (valueLen - lenA * countA) / countB;

            // 如果a和b可以组成value长度的字符串就继续
            if (lenB >= 0 && countA * lenA + countB * lenB == valueLen) {
                int firstB = pattern.indexOf('b') * lenA;
                b = value.substring(firstB, firstB + lenB);
                StringBuilder temp = new StringBuilder();
                for (char c : pattern.toCharArray()) {
                    if (c == 'a') {
                        temp.append(a);
                    } else {
                        temp.append(b);
                    }
                }
                if (!a.equals(b) && value.equals(temp.toString())) {
                    return true;
                }
            }
            lenA++;
        }
        return false;
    }

    @Test
    void test1618() {
        String p = "abbbb";
        String v = "hggmuhqsudtcbyhcuumscubdbtumscubdbumscubdb";
        System.out.println(patternMatching(p, v));
    }
}
