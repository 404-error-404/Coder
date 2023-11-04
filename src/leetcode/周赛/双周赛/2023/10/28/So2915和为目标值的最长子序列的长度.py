#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/4 15:25
# @Remarks  : 给你一个下标从 0 开始的整数数组 nums 和一个整数 target 。
#
# 返回和为 target 的 nums 子序列中，子序列 长度的最大值 。如果不存在和为 target 的子序列，返回 -1 。
#
# 子序列 指的是从原数组中删除一些或者不删除任何元素后，剩余元素保持原来的顺序构成的数组。
#
# https://leetcode.cn/contest/biweekly-contest-116/problems/length-of-the-longest-subsequence-that-sums-to-target/
from typing import List


class Solution:
    def recursion(self, nums: List[int], target: int) -> int:
        if target == 0:
            return 0
        # 先截断
        if len(nums) == 0 or nums[0] > target:
            return -1
        if nums[-1] > target:
            left = 0
            right = len(nums) - 1
            while left != right - 1:
                mid = (right + left) // 2
                if nums[mid] > target:
                    right = mid
                else:
                    left = mid
            nums = nums[:right+1]

        res = -1
        for n in nums:
            new_nums = nums.copy()
            new_nums.remove(n)
            tmp = self.recursion(new_nums, target - n)
            if tmp != -1:
                res = max(1 + tmp, res)
        return res

    def lengthOfLongestSubsequence(self, nums: List[int], target: int) -> int:
        # TODO 超时
        nums.sort()
        return self.recursion(nums, target)


s = Solution()
print(s.lengthOfLongestSubsequence(nums=[1, 2], target=10))
