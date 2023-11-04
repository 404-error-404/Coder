#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/10/7 18:51
# @Remarks  :
# 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
# 
# 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
# 
# 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
# 
# 请你返回「表现良好时间段」的最大长度。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/longest-well-performing-interval
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def longestWPI(self, hours: List[int]) -> int:
        count = {}
        tmp_sum = 0
        res = 0
        for i in range(len(hours)):
            tmp_sum += 1 if hours[i] > 8 else -1
            if tmp_sum > 0:
                res = i + 1
            else:
                if tmp_sum - 1 in count:
                    res = max(res, i - count[tmp_sum - 1])
                else:
                    count[tmp_sum] = count.get(tmp_sum, i)
        return res
