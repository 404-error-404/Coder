#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/4/30 22:27
# @desc :
# 给你一个字符串数组 words 和一个字符串 s ，其中 words[i] 和 s 只包含 小写英文字母 。
# 
# 请你返回 words 中是字符串 s 前缀 的 字符串数目 。
# 
# 一个字符串的 前缀 是出现在字符串开头的子字符串。子字符串 是一个字符串中的连续一段字符序列。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/count-prefixes-of-a-given-string
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def countPrefixes(self, words: List[str], s: str) -> int:
        res = 0
        for w in words:
            if s.startswith(w):
                res += 1
        return res
