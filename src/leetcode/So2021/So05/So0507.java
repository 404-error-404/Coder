package leetcode.So2021.So05;

/**
 * 给你两个整数，n 和 start 。
 *
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/7 11:13
 **/
public class So0507 {
    public int xorOperation(int n, int start) {
        // 直接for循环遍历即可
        int ans = start;
        for(int i = 1; i < n; i++){
            ans ^= start + 2*i;
        }
        return ans;
    }

    public static void main(String[] args) {
        // n = 5, start = 0; ans = 8
        System.out.println(new So0507().xorOperation(5, 0));
        // n = 4, start = 3; ans = 8
        System.out.println(new So0507().xorOperation(4, 3));
    }
}
