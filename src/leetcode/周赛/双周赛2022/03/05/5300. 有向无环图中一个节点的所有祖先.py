#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/3/5 23:03
# @Remarks  :
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
