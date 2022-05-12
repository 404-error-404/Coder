package leetcode.贪心;

import leetcode.TreeNode;

/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-cameras
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/12 15:47
 */
public class So968监控二叉树 {
    int res;

    /**
     * @return -1: 摄像头下层; 0: 是摄像头; 1: 摄像头上层
     */
    public int postOrder(TreeNode root) {
        if (null == root) {
            return 1;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);

        // 孩子节点存在摄像头下层节点
        if (left == -1 || right == -1) {
            res++;
            return 0;
        }
        // 孩子节点存在摄像头
        if (left == 0 || right == 0) {
            return 1;
        }
        return -1;
    }

    public int minCameraCover(TreeNode root) {
        res = 0;
        if (postOrder(root) == -1) {
            res++;
        }
        return res;
    }
}
