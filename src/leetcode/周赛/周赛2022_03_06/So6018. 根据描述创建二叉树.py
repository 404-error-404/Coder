#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/3/6 10:29
# @Remarks  :
# 给你一个二维整数数组 descriptions ，
# 其中 descriptions[i] = [parenti, childi, isLefti] 表示 parenti 是 childi 在 二叉树 中的 父节点，
# 二叉树中各节点的值 互不相同 。此外：
#
# 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。
# 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。
# 请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。
#
# 测试用例会保证可以构造出 有效 的二叉树。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/create-binary-tree-from-descriptions
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        tree = {}
        all_nodes = set()
        child_set = set()
        # 构造二叉树
        for i in descriptions:
            parent = i[0]
            child = i[1]
            all_nodes.add(parent)
            all_nodes.add(child)
            child_set.add(child)
            if parent not in tree.keys():
                tree[parent] = TreeNode(parent)
            if child not in tree.keys():
                tree[child] = TreeNode(child)
            # 右子节点
            if i[2] == 0:
                tree[parent].right = tree[child]
            # 左子节点
            else:
                tree[parent].left = tree[child]
        # 头结点
        head = (all_nodes - child_set).pop()
        return tree[head]


s = Solution()
print(s.createBinaryTree([[1, 2, 1], [2, 3, 0], [3, 4, 1]]))
