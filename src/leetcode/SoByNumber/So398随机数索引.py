#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/10/7 19:23
# @Remarks  :
# 给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。你可以假设给定的数字一定存在于数组中。
# 
# 实现 Solution 类：
# 
# Solution(int[] nums) 用数组 nums 初始化对象。
# int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i 。如果存在多个有效的索引，则每个索引的返回概率应当相等。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/random-pick-index
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
import random
from collections import defaultdict
from typing import List


class Solution:
    """
    力扣评判是随机数，不一定给通过（2022.10.07）
    """
    idx = defaultdict(list)

    def __init__(self, nums: List[int]):
        for i in range(len(nums)):
            self.idx[nums[i]].append(i)

    def pick(self, target: int) -> int:
        return random.choice(self.idx[target])


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)
