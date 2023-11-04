#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/10/30 21:41
# @Remarks  : 给你两个由正整数和 0 组成的数组 nums1 和 nums2 。
#
# 你必须将两个数组中的 所有 0 替换为 严格 正整数，并且满足两个数组中所有元素的和 相等 。
#
# 返回 最小 相等和 ，如果无法使两数组相等，则返回 -1 。
from typing import List


class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        sum1 = sum(nums1)
        sum2 = sum(nums2)

        count_0_1 = nums1.count(0)
        count_0_2 = nums2.count(0)

        # 若有答案，则是sum + 0个数，取两数组中较大的为答案
        # 若无答案，则是其中一个数组没有0且另一个补0后超出该数组
        if count_0_1 == 0:
            if count_0_2 + sum2 > sum1:
                return -1
        if count_0_2 == 0:
            if count_0_1 + sum1 > sum2:
                return -1
        return max(sum1 + count_0_1, sum2 + count_0_2)
