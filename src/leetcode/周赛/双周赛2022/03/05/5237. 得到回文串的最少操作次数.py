#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/3/5 23:27
# @Remarks  :
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
