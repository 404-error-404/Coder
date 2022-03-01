package leetcode.So05;


/**
 * 用来表示二叉树
 */
class Trie {
    Trie left = null;
    Trie right = null;
}

/**
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/16 11:38
 **/
public class So0516 {
    int highBit = 31;

    Trie root = new Trie();

    /**
     * 应该把数组构造成二叉树，这样可以减少遍历，每次向数组中添加一个数就用该数字和二叉树进行异或操作以获取最大值
     * @param nums 给定的数组
     * @return     数组中两个元素异或的最大值
     */
    public int findMaximumXOR(int[] nums) {
        int ans = 0;

        for(int i: nums){
            add2Tree(i);
            ans = Math.max(ans, check(i));
        }

        return ans;
    }

    /**
     * 向构造好的二叉树中添加整数
     * @param i 待添加数字
     */
    void add2Tree(int i){
        Trie cur = root;
        String binaryInt = Integer.toBinaryString(i);
        int j = highBit - binaryInt.length();
        while (j > 0){
            if(null == cur.left){
                cur.left = new Trie();
            }
            cur = cur.left;
            j--;
        }
        for(int k = 0; k < binaryInt.length(); k++){
            if('0' == binaryInt.charAt(k)){
                // 往左孩子加
                if(null == cur.left){
                    cur.left = new Trie();
                }
                cur = cur.left;
            }
            else {
                // 往右孩子加
                if(null == cur.right){
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }

    /**
     * 不会做，抄的题解
     * @param num 当前加入的数字
     * @return    当前数字和其他数字异或的最大值
     */
    public int check(int num) {
        Trie cur = root;
        int x = 0;
        for (int k = highBit-1; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走
                if (cur.right != null) {
                    cur = cur.right;
                    x = x * 2 + 1;
                } else {
                    cur = cur.left;
                    x = x * 2;
                }
            } else {
                // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
                if (cur.left != null) {
                    cur = cur.left;
                    x = x * 2 + 1;
                } else {
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8};
        System.out.println(
                new So0516().findMaximumXOR(arr)
        );
    }
}
