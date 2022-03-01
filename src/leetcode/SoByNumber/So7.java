package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/9/20 12:15
 **/
public class So7 {
    public int reverse(int x){
        String s = String.valueOf(x);
        if (x < 0){
            s = s.substring(1) + "-";
        }
        StringBuilder stringBuilder = new StringBuilder(s).reverse();
        long xL = Long.parseLong(stringBuilder.toString());
        if (xL > Integer.MAX_VALUE || xL < Integer.MIN_VALUE){
            return 0;
        }
        else {
            return (int)xL;
        }
    }

    @Test
    public void testReverse(){
        int x = -21;
        System.out.println(reverse(x));
    }
}
