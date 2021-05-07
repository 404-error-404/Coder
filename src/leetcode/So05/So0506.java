package leetcode.So05;

import java.util.Arrays;

/**
 * 未知 整数数组 arr 由 n 个非负整数组成。
 *
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 *
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 *
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/5/6 12:33
 */
public class So0506 {
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length + 1;
        int[] ans = new int[len];
        ans[0] = first;
        int i = 1;
        // 对A ^ B = C逆运算即可
        // C ^ A = B
        while (i < len) {
            ans[i] = ans[i-1] ^ encoded[i-1];
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] encode = new int[]{1,2,3};
        int first = 1;
        System.out.println(Arrays.toString(new So0506().decode(encode, first)));
    }
}
