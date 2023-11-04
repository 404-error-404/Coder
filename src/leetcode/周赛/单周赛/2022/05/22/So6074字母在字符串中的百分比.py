#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/5/22 10:31
# @desc :
# 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/percentage-of-letter-in-string
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution:
    def percentageLetter(self, s: str, letter: str) -> int:
        count = [0] * 26
        total = 0
        for i in s:
            count[ord(i) - ord('a')] += 1
            total += 1
        return count[ord(letter) - ord('a')] * 100 // total
