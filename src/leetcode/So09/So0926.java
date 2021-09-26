package leetcode.So09;

import org.junit.Test;

/**
 *  给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/9/26 20:04
 **/
public class So0926 {
    public int getSum(int a, int b) {
        while (b != 0){
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }

    @Test
    public void testGetSum(){
        System.out.println(
                getSum(6, 8)
        );
    }
}
