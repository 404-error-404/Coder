#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/5/28 23:17
# @desc :
# 给你一个整数 n ，表示一个国家里的城市数目。城市编号为 0 到 n - 1 。
# 
# 给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] 表示城市 ai 和 bi 之间有一条 双向 道路。
# 
# 你需要给每个城市安排一个从 1 到 n 之间的整数值，且每个值只能被使用 一次 。道路的 重要性 定义为这条道路连接的两座城市数值 之和 。
# 
# 请你返回在最优安排下，所有道路重要性 之和 最大 为多少。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/maximum-total-importance-of-roads
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def maximumImportance(self, n: int, roads: List[List[int]]) -> int:
        # dict记录城市联通的联通道路数
        # 从小到大进行赋权
        count = {i: 0 for i in range(n)}
        for start, end in roads:
            count[start] += 1
            count[end] += 1
        value = [0] * n
        i = 1
        sorted_city = sorted(count.items(), key=lambda x: x[1])
        for city, _ in sorted_city:
            value[city] = i
            i += 1
        res = 0
        for start, end in roads:
            res += value[start] + value[end]
        return res
