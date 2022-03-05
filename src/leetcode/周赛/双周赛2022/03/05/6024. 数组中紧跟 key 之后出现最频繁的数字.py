#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/3/5 22:32
# @Remarks  :
from typing import List


class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        targets = {}
        for i in range(len(nums) - 1):
            if nums[i] == key:
                if nums[i + 1] in targets.keys():
                    count = targets[nums[i + 1]] + 1
                else:
                    count = 1
                targets[nums[i + 1]] = count
        res_list = sorted(targets.items(), key=lambda x: x[1], reverse=True)
        return res_list[0][0]


s = Solution()
print(s.mostFrequent([1, 1000, 2], 1000))
