#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/6/11 23:00
# @Remarks  :
# 给你两个字符串 s 和 sub 。
# 同时给你一个二维字符数组 mappings ，其中 mappings[i] = [oldi, newi] 表示你可以替换 sub 中任意数目的 oldi 个字符，替换成 newi 。
# sub 中每个字符 不能 被替换超过一次。
# 
# 如果使用 mappings 替换 0 个或者若干个字符，可以将 sub 变成 s 的一个子字符串，请你返回 true，否则返回 false 。
# 
# 一个 子字符串 是字符串中连续非空的字符序列。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/match-substring-after-replacement
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def matchReplacement(self, s: str, sub: str, mappings: List[List[str]]) -> bool:
        # TODO 目前题解是暴力匹配
        pass


s = "gfnk9rmyi1a4zvxzvt1ze0g"
sub = "gfnk9rmyi1a4zvxzv71zeo"
mappings = [["4", "a"], ["1", "l"], ["o", "0"], ["l", "i"], ["e", "3"], ["7", "t"]]
so = Solution()
print(so.matchReplacement(s, sub, mappings))
