#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/5/1 10:34
# @desc :
# 给你一个整数数组 nums 和两个整数 k 和 p ，找出并返回满足要求的不同的子数组数，要求子数组中最多 k 个可被 p 整除的元素。
#
# 如果满足下述条件之一，则认为数组 nums1 和 nums2 是 不同 数组：
#
# 两数组长度 不同 ，或者
# 存在 至少 一个下标 i 满足 nums1[i] != nums2[i] 。
# 子数组 定义为：数组中的连续元素组成的一个 非空 序列。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/k-divisible-elements-subarrays
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def add_sub_list(self, nums: List[int], res: set):
        if len(nums) == 0:
            return
        t = tuple(nums)
        if t in res:
            return
        res.add(t)
        self.add_sub_list(nums[:-1], res)
        self.add_sub_list(nums[1:], res)

    def countDistinct(self, nums: List[int], k: int, p: int) -> int:
        sub_nums_k = set()
        p_idx = [-1]
        count = 0
        for i in range(len(nums)):
            n = nums[i]
            if n % p == 0:
                p_idx.append(i)
        p_idx.append(len(nums))

        res = set()
        if len(p_idx) - 2 < k:
            self.add_sub_list(nums, res)
        else:
            for i in range(1, len(p_idx) - k):
                l = p_idx[i - 1] + 1
                r = p_idx[i + k]
                self.add_sub_list(nums[l:r], res)
        return len(res)


s = Solution()
arrs = [2, 3, 3, 2, 2]
k = 2
p = 2
ans = s.countDistinct(arrs, k, p)
print(ans)
