#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/3/5 23:27
# @desc :
# 给你一个只包含小写英文字母的字符串 s 。
# 
# 每一次 操作 ，你可以选择 s 中两个 相邻 的字符，并将它们交换。
# 
# 请你返回将 s 变成回文串的 最少操作次数 。
# 
# 注意 ，输入数据会确保 s 一定能变成一个回文串。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/minimum-number-of-moves-to-make-palindrome
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def move_edge_char(self, s_list: List[str]) -> int:
        s_len = len(s_list)
        if s_len <= 2:
            return 0
        step = 0
        while s_list[step] != s_list[-1] and s_list[step * -1 - 1] != s_list[0]:
            step += 1
        if s_list[step] == s_list[-1]:
            s_list[1:step + 1] = s_list[:step]
        else:
            s_list[step * -1 - 1:-1] = s_list[step * -1:]
        return step + self.move_edge_char(s_list[1:-1])

    def minMovesToMakePalindrome(self, s: str) -> int:
        s_list = list(s)
        return self.move_edge_char(s_list)


s = Solution()
print(s.minMovesToMakePalindrome("skwhhaaunskegmdtutlgtteunmuuludii"))
