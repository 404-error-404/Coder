package leetcode.SoByNumber;

/**
 * 「无零整数」是十进制表示中 不含任何 0的正整数。
 *
 * 给你一个整数n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 *
 * A 和 B都是无零整数
 * A + B = n
 * 题目数据保证至少有一个有效的解决方案。
 *
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/7/22 18:53
 **/
public class So1317 {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1, j = n - 1; i < n; ){
            String iString = Integer.toString(i);
            if(iString.contains("0")){
                iString = iString.replaceAll("0", "1");
                i = Integer.parseInt(iString);
                j = n - i;
            }
            if (Integer.toString(j).contains("0")){
                i++;
                j = n - i;
            }
            else {
                return new int[]{i,j};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(
                new So1317().getNoZeroIntegers(40)[0]
        );
    }
}
