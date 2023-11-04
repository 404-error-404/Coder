#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/4/24 16:35
# @desc :
# 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/intersection-of-multiple-arrays
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def intersection(self, nums: List[List[int]]) -> List[int]:
        count = {}
        for l in nums:
            for i in l:
                if i in count.keys():
                    count[i] += 1
                else:
                    count[i] = 1

        nums_len = len(nums)
        res = []
        for item in count.items():
            if item[1] == nums_len:
                res.append(item[0])
        res.sort()
        return res


s = Solution()
ans = s.intersection([[3, 1, 2, 4, 5], [1, 2, 3, 4], [3, 4, 5, 6]])
print(ans)
print(s.intersection([[44,21,48]]))
