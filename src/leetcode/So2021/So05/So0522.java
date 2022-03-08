package leetcode.So2021.So05;

/**
 * 黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。 (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）
 *
 * 换种说法就是，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。
 *
 * 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chalkboard-xor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/22 14:25
 **/
public class So0522 {
    /**
     * 数学方法，不会做，看官方题解
     * @param nums 给定数组
     * @return     先手Alice能否获胜
     */
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int i: nums){
            xor ^= i;
        }
        return xor == 0 || nums.length % 2 == 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(
                new So0522().xorGame(nums)
        );
    }
}
