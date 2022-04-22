package leetcode.字符串.左旋转字符串;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/13 19:40
 **/
public class Offer58Ⅱ左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        return String.valueOf(Arrays.copyOfRange(chars, n, chars.length)) + String.valueOf(Arrays.copyOfRange(chars, 0, n));
    }

    @Test
    public void test(){
        String s = "阿萨开连接方式克拉的房间里";
        int n = 2;
        System.out.println(reverseLeftWords(s, n));
    }
}
