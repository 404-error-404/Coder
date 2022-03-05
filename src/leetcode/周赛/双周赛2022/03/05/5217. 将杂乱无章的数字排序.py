#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/3/5 22:45
# @Remarks  :
from typing import List


class Solution:
    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        nums_map = []
        for n in nums:
            n_list = list(str(n))
            for i in range(len(n_list)):
                n_list[i] = str(mapping[int(n_list[i])])
            nums_map.append([n, int("".join(n_list))])
        res_list = sorted(nums_map, key=lambda x: x[1])
        return [i[0] for i in res_list]


s = Solution()
mapping = [8, 2, 9, 5, 3, 7, 1, 0, 6, 4]
nums = [77, 45, 77]
res = s.sortJumbled(mapping, nums)
print(res)
