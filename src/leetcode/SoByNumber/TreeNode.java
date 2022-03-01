package leetcode.SoByNumber;

/**
 * @author 小乐乐
 * @date 2021/4/25 11:05
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
//    public TreeNode newTreeNode(int[] arr){
//        int len = arr.length;
//        TreeNode[] nodes = new TreeNode[len];
//        for(int i = 0; i < len/2; i++){
//            nodes[i].val = arr[i];
//            nodes[i].left = nodes[i*2];
//            nodes[i].right = nodes[i*2+1];
//        }
//        for(int i = len/2; i< len; i++){
//            nodes[i].val = arr[i];
//        }
//        return nodes[0];
//    }
}