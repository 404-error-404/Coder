#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/3/6 10:29
# @Remarks  :
# 给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 。
#
# 返回追加到 nums 中的 k 个整数之和。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/append-k-integers-with-minimal-sum
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def minimalKSum(self, nums: List[int], k: int) -> int:
        nums = list(set(nums))
        nums.sort()
        index = 0
        while index < len(nums) and nums[index] <= k:
            index += 1
            k += 1
        return (1 + k) * k // 2 - sum(nums[:index])


s = Solution()
print(s.minimalKSum([1], 3))
print(s.minimalKSum([1], 1000000000))
print(s.minimalKSum(
    [96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21, 72, 100, 40, 84],
    35))
print(s.minimalKSum([53, 41, 90, 33, 84, 26, 50, 32, 63, 47, 66, 43, 29, 88, 71, 28, 83], 76))
print(s.minimalKSum([531, 141, 190, 133, 184, 126, 150, 132, 163, 147, 616, 413, 129, 88, 711, 218, 813], 76))
