#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/10/30 21:47
# @Remarks  : 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和一个整数 k 。
#
# 你可以执行下述 递增 运算 任意 次（可以是 0 次）：
#
# 从范围 [0, n - 1] 中选择一个下标 i ，并将 nums[i] 的值加 1 。
# 如果数组中任何长度 大于或等于 3 的子数组，其 最大 元素都大于或等于 k ，则认为数组是一个 美丽数组 。
#
# 以整数形式返回使数组变为 美丽数组 需要执行的 最小 递增运算数。
#
# 子数组是数组中的一个连续 非空 元素序列。
from typing import List


class Solution:
    def minIncrementOperations(self, nums: List[int], k: int) -> int:
        dp = [0] * len(nums)
        dp[0] = max(k - nums[0], 0)
        dp[1] = min(k - nums[1], dp[0])
        if dp[1] < 0:
            dp[1] = 0
        dp[2] = min(k - nums[2], dp[1])
        if dp[2] < 0:
            dp[2] = 0
        for i in range(3, len(nums)):
            dp[i] = min(dp[i - 3] + max(k - nums[i], 0), dp[i - 1])
        return dp[-1]


s = Solution()
res = s.minIncrementOperations(nums=[2, 3, 0, 0, 2], k=4)
print(res)
