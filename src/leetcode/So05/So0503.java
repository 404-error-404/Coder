package leetcode.So05;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例：123->321
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/3 15:31
 **/
public class So0503 {
    public static int reverse(int x) {
        String s = String.valueOf(x);
        // 直接使用StringBuilder实现字符串反转
        StringBuilder res = new StringBuilder(s).reverse();
        // 如果x小于0要把负号提到最开始
        if(x < 0){
            res.deleteCharAt(s.length()-1);
            res.insert(0, '-');
        }
        // 判断是否超出了int的范围
        long ans = Long.parseLong(res.toString());
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            return 0;
        }
        else{
            return (int)ans;
        }
    }
    public static void main(String[] args) {
        System.out.println(reverse(Integer.MIN_VALUE));
    }
}
