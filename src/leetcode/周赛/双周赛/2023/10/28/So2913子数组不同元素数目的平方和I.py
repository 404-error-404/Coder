#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/4 15:08
# @Remarks  : 给你一个下标从 0 开始的整数数组 nums 。
#
# 定义 nums 一个子数组的 不同计数 值如下：
#
# 令 nums[i..j] 表示 nums 中所有下标在 i 到 j 范围内的元素构成的子数组（满足 0 <= i <= j < nums.length ），那么我们称子数组 nums[i..j] 中不同值的数目为 nums[i..j] 的不同计数。
# 请你返回 nums 中所有子数组的 不同计数 的 平方 和。
#
# 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。
#
# 子数组指的是一个数组里面一段连续 非空 的元素序列。
#
# https://leetcode.cn/contest/biweekly-contest-116/problems/subarrays-distinct-element-sum-of-squares-i/
from typing import List


class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        MOD = 1000000007
        res = 0
        for start in range(len(nums)):
            for end in range(start, len(nums)):
                tmp = len(set(nums[start:end + 1]))
                res += tmp * tmp
                res %= MOD
        return res
