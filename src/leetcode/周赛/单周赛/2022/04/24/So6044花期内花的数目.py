#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/4/24 18:33
# @desc :
# 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 persons ，persons[i] 是第 i 个人来看花的时间。
# 
# 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/number-of-flowers-in-full-bloom
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from collections import defaultdict
from typing import List


class Solution:
    # TODO 之后可以重做一下
    def fullBloomFlowers(self, flowers: List[List[int]], persons: List[int]) -> List[int]:
        diff = defaultdict(int)
        for start, end in flowers:
            diff[start] += 1
            diff[end+1] -= 1
        times = sorted(diff.keys())

        n = len(persons)
        res = [0] * n
        count = 0
        cur_p = 0
        # 记住这个zip的用法
        for p, idx in sorted(zip(persons, range(n))):
            # p: 到达时间
            # idx: 这个人的顺序
            while cur_p < len(times) and times[cur_p] <= p:
                count += diff[times[cur_p]]
                cur_p += 1
            res[idx] = count
        return res
