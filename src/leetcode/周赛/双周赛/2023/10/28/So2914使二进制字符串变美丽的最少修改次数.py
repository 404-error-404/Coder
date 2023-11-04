#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/4 15:16
# @Remarks  : 给你一个长度为偶数下标从 0 开始的二进制字符串 s 。
#
# 如果可以将一个字符串分割成一个或者更多满足以下条件的子字符串，那么我们称这个字符串是 美丽的 ：
#
# 每个子字符串的长度都是 偶数 。
# 每个子字符串都 只 包含 1 或 只 包含 0 。
# 你可以将 s 中任一字符改成 0 或者 1 。
#
# 请你返回让字符串 s 美丽的 最少 字符修改次数。
#
# https://leetcode.cn/contest/biweekly-contest-116/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
class Solution:
    def minChanges(self, s: str) -> int:
        # 等价于对所有偶数下标i有s[i] == s[i+1]
        res = 0
        for i in range(0, len(s), 2):
            res += s[i] != s[i+1]
        return  res