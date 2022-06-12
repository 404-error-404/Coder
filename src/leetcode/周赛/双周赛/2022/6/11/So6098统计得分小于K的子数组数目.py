#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/6/11 23:08
# @Remarks  :
# 一个数字的 分数 定义为数组之和 乘以 数组的长度。
# 
# 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
# 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
# 
# 子数组 是数组中的一个连续元素序列。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/count-subarrays-with-score-less-than-k
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        res = left = cur_sum = 0

        # 滑动窗口查找满足的数组
        for right, num in enumerate(nums):
            cur_sum += num
            while cur_sum * (right - left + 1) >= k:
                cur_sum -= nums[left]
                left += 1
            res += right - left + 1
        return res


nums_ = [2, 1, 4, 3, 5]
k_ = 10
s = Solution()
print(s.countSubarrays(nums_, k_))
