#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/3/5 22:32
# @Remarks  :
# 给你一个下标从 0 开始的整数数组 nums ，同时给你一个整数 key ，它在 nums 出现过。
#
# 统计 在 nums 数组中紧跟着 key 后面出现的不同整数 target 的出现次数。换言之，target 的出现次数为满足以下条件的 i 的数目：
#
# 0 <= i <= n - 2
# nums[i] == key 且
# nums[i + 1] == target 。
# 请你返回出现 最多 次数的 target 。测试数据保证出现次数最多的 target 是唯一的。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/most-frequent-number-following-key-in-an-array
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。给你一个下标从 0 开始的整数数组 nums ，同时给你一个整数 key ，它在 nums 出现过。
#
# 统计 在 nums 数组中紧跟着 key 后面出现的不同整数 target 的出现次数。换言之，target 的出现次数为满足以下条件的 i 的数目：
#
# 0 <= i <= n - 2
# nums[i] == key 且
# nums[i + 1] == target 。
# 请你返回出现 最多 次数的 target 。测试数据保证出现次数最多的 target 是唯一的。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/most-frequent-number-following-key-in-an-array
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        targets = {}
        for i in range(len(nums) - 1):
            if nums[i] == key:
                if nums[i + 1] in targets.keys():
                    count = targets[nums[i + 1]] + 1
                else:
                    count = 1
                targets[nums[i + 1]] = count
        res_list = sorted(targets.items(), key=lambda x: x[1], reverse=True)
        return res_list[0][0]


s = Solution()
print(s.mostFrequent([1, 1000, 2], 1000))
