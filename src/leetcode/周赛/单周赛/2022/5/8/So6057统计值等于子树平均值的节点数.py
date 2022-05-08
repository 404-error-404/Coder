# 给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。
#
# 注意：
#
# · n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
# · root 的 子树 由 root 和它的所有后代组成。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/count-nodes-equal-to-average-of-subtree
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    res = 0

    def dfs(self, root: Optional[TreeNode]) -> (int, int):
        if root is None:
            return 0, 0
        ls, ln = self.dfs(root.left)
        rs, rn = self.dfs(root.right)

        new_sum = ls + rs + root.val
        new_count = ln + rn + 1

        if new_sum // new_count == root.val:
            self.res += 1
        return new_sum, new_count

    def averageOfSubtree(self, root: Optional[TreeNode]) -> int:
        self.res = 0
        self.dfs(root)
        return self.res
