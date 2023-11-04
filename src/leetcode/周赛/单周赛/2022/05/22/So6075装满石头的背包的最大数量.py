#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/5/22 10:35
# @desc :
# 现有编号从 0 到 n - 1 的 n 个背包。给你两个下标从 0 开始的整数数组 capacity 和 rocks 。
# 第 i 个背包最大可以装 capacity[i] 块石头，当前已经装了 rocks[i] 块石头。另给你一个整数 additionalRocks ，表示你可以放置的额外石头数量，石头可以往 任意 背包中放置。
# 
# 请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 最大 数量。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/maximum-bags-with-full-capacity-of-rocks
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def maximumBags(self, capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
        rest_capacity = list(map(lambda x, y: x - y, capacity, rocks))
        rest_capacity.sort()
        res = 0
        for i in rest_capacity:
            if i == 0:
                res += 1
            elif i <= additionalRocks:
                res += 1
                additionalRocks -= i
            else:
                return res
        return res


s = Solution()
print(s.maximumBags([10, 2, 2], [2, 2, 0], 2))
