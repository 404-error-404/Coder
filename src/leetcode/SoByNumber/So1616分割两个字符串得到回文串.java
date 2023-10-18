package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

/**
 * @author 小乐乐
 * @date 2023/3/18 1:37
 **/
public class So1616分割两个字符串得到回文串 {
    public boolean checkPalindromeFormation(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int lenA = charsA.length;
        int lenB = charsB.length;
        int minLen = Math.min(lenA, lenB);
        int idx = 0;
        while (idx < minLen & charsA[idx] == charsB[charsB.length - idx - 1]) {
            idx++;
        }
        System.out.println(idx);
        return false;
    }

    @Test
    public void test() {
        String a = "abdef", b = "fecab";
        checkPalindromeFormation(a, b);
    }
}
