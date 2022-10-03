#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/4/30 22:27
# @desc :
# 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
#
# 下标 i 处的 平均差 指的是 nums 中 前 i + 1 个元素平均值和 后 n - i - 1 个元素平均值的 绝对差 。两个平均值都需要 向下取整 到最近的整数。
#
# 请你返回产生 最小平均差 的下标。如果有多个下标最小平均差相等，请你返回 最小 的一个下标。
#
# 注意：
#
# 两个数的 绝对差 是两者差的绝对值。
#  n 个元素的平均值是 n 个元素之 和 除以（整数除法） n 。
# 0 个元素的平均值视为 0 。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/minimum-average-difference
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        nums_len = len(nums)
        left_sum = 0
        left_count = 0
        right_sum = sum(nums)
        right_count = nums_len

        min_diff = abs(right_sum // nums_len) + 1
        min_idx = nums_len - 1

        for i in range(nums_len - 1):
            left_sum += nums[i]
            right_sum -= nums[i]
            left_count += 1
            right_count -= 1
            tmp = abs(left_sum // left_count - right_sum // right_count)
            if tmp < min_diff:
                min_diff = tmp
                min_idx = i
        return min_idx


s = Solution()
t = s.minimumAverageDifference([2, 5, 3, 9, 5, 3])
print(t)
