package leetcode.So05;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/5/31 15:43
 */
public class So0531 {
    /**
     * 转成二进制字符串依次按条件判断
     * @param n 待判断整数
     * @return  是否为4的整数幂次方
     */
    public boolean isPowerOfFour(int n) {
        if(n <= 0){
            return false;
        }
        String s = Integer.toBinaryString(n);
        // 4的幂次方满足第一位是1，后边全是0而且总长度为奇数
        if(s.charAt(0) != '1'){
            return false;
        }
        if(s.length() %2 != 1){
            return false;
        }
        return s.indexOf('1', 1) < 0;
    }

    public static void main(String[] args) {
        for(int i = 2; i < 5000; i*=4) {
            System.out.println(
                    new So0531().isPowerOfFour(i)
            );
        }
    }
}
