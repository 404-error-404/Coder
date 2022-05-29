#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/5/29 21:40
# @Remarks  :
# 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，移除所有满足 nums[i - 1] > nums[i] 的 nums[i] ，其中 0 < i < nums.length 。
# 
# 重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/steps-to-make-array-non-decreasing
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


# TODO 超时
class Solution:
    def totalSteps(self, nums: List[int]) -> int:
        is_changed = False
        i = len(nums) - 1
        while i > 0:
            if nums[i] < nums[i - 1]:
                del nums[i]
                is_changed = True
            i -= 1
        if is_changed:
            return 1 + self.totalSteps(nums)
        else:
            return 0


s = Solution()
print(s.totalSteps([5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11]))
