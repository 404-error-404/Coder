#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/10/30 21:30
# @Remarks  : 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
#
# nums 中的 K-or 是一个满足以下条件的非负整数：
#
# 只有在 nums 中，至少存在 k 个元素的第 i 位值为 1 ，那么 K-or 中的第 i 位的值才是 1 。
# 返回 nums 的 K-or 值。
#
# 注意 ：对于整数 x ，如果 (2i AND x) == 2i ，则 x 中的第 i 位值为 1 ，其中 AND 为按位与运算符。
from typing import List


class Solution:
    def findKOr(self, nums: List[int], k: int) -> int:
        nums.sort()
        nums = [bin(i)[:1:-1] for i in nums]
        count = [0] * len(nums[-1])
        for i in range(len(count)):
            tmp = 0
            for n in nums:
                if len(n) > i and n[i] == "1":
                    tmp += 1
            count[i] = "1" if tmp >= k else "0"
        count.reverse()
        return int("".join(count), 2)


s = Solution()
res = s.findKOr(nums=[7, 12, 9, 8, 9, 15], k=4)
print(res)
