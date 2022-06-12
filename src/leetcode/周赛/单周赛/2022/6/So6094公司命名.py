#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/6/12 16:16
# @Remarks  :
# 给你一个字符串数组 ideas 表示在公司命名过程中使用的名字列表。公司命名流程如下：
#
# 从 ideas 中选择 2 个 不同 名字，称为 ideaA 和 ideaB 。
# 交换 ideaA 和 ideaB 的首字母。
# 如果得到的两个新名字 都 不在 ideas 中，那么 ideaA ideaB（串联 ideaA 和 ideaB ，中间用一个空格分隔）是一个有效的公司名字。
# 否则，不是一个有效的名字。
# 返回 不同 且有效的公司名字的数目。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/naming-a-company
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from collections import defaultdict
from typing import List


class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        # 以首字母为key分组
        group = defaultdict(set)
        for i in ideas:
            group[i[0]].add(i[1:])

        res = 0

        # 对任意两个key求合法的公司名字
        keys = list(group.keys())
        keys_len = len(keys)
        for i in range(keys_len - 1):
            for j in range(i + 1, keys_len):
                i_str = group[keys[i]]
                j_str = group[keys[j]]
                # keys[i]开头单词数量
                m = len(i_str)
                # keys[j]开头单词数
                n = len(j_str)

                # 重复数量
                k = len(i_str & j_str)
                res += (m - k) * (n - k)
        return res * 2


ideas_ = ["coffee", "donuts", "time", "toffee"]
s = Solution()
print(s.distinctNames(ideas_))
