#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/3/5 23:27
# @desc :
# 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/max-consecutive-ones-iii
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        nums_len = len(nums)
        if nums.count(1) == 0:
            return min(nums_len, k)

        left = 0
        right = 0
        count0 = 1 - nums[0]
        while right + 1 < nums_len and nums[right + 1] == 1:
            right += 1
        res = right - left + 1
        while right < nums_len:
            if nums[right] == 1:
                right += 1
                res = max(res, right - left + 1)
            elif count0 < k:
                right += 1
                count0 += 1
                res = max(res, right - left + 1)
            else:
                count0 -= 1 - nums[left]
                left += 1
                if left == right:
                    left += 1
                    right += 1
                    if left != nums_len:
                        count0 = 1 - nums[left]
                    else:
                        count0 = 0
        return res

s = Solution()
print(s.longestOnes([1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1], 2))
