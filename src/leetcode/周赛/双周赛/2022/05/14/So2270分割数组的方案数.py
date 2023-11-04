#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/5/21 19:55
# @desc :
# 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
# 如果以下描述为真，那么 nums 在下标 i 处有一个 合法的分割 ：
#
# 前 i + 1 个元素的和 大于等于 剩下的 n - i - 1 个元素的和。
# 下标 i 的右边 至少有一个 元素，也就是说下标 i 满足 0 <= i < n - 1 。
# 请你返回 nums 中的 合法分割 方案数。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/number-of-ways-to-split-array
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        res = 0
        total = sum(nums)
        nums_len = len(nums)
        i = 0
        while i < nums_len - 1:
            total -= nums[i] * 2
            if total <= 0:
                res += 1
            i += 1
        return res


s = Solution()
print(s.waysToSplitArray([2, 3]))
