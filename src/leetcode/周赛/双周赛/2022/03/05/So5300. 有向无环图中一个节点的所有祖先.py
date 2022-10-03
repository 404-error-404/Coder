#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/3/5 23:03
# @desc :
# 给你一个正整数 n ，它表示一个 有向无环图 中节点的数目，节点编号为 0 到 n - 1 （包括两者）。
# 
# 给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi] 表示图中一条从 fromi 到 toi 的单向边。
# 
# 请你返回一个数组 answer，其中 answer[i]是第 i 个节点的所有 祖先 ，这些祖先节点 升序 排序。
# 
# 如果 u 通过一系列边，能够到达 v ，那么我们称节点 u 是节点 v 的 祖先 节点。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        # 初始化map
        res_map = {}
        for i in range(n):
            res_map[i] = set()
        # 初始化直系父节点
        for i in edges:
            res_map[i[1]].add(i[0])
        res = []
        for i in range(n):
            parents_set = set()
            temp_set = res_map[i]
            diff_set = temp_set - parents_set
            while len(diff_set) != 0:
                parents_set = temp_set
                for j in diff_set:
                    temp_set = temp_set | res_map[j]
                diff_set = temp_set - parents_set
            parents_list = list(parents_set)
            parents_list.sort()
            res.append(parents_list)
        return res


s = Solution()
print(s.getAncestors(10, [[5, 2], [8, 7], [7, 2], [8, 3], [1, 6], [9, 0]]))
