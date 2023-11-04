#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/3/6 10:29
# @desc :
# Excel 表中的一个单元格 (r, c) 会以字符串 "<col><row>" 的形式进行表示，其中：
#
# <col> 即单元格的列号 c 。用英文字母表中的 字母 标识。
# 例如，第 1 列用 'A' 表示，第 2 列用 'B' 表示，第 3 列用 'C' 表示，以此类推。
#
# <row> 即单元格的行号 r 。第 r 行就用 整数 r 标识。
#
# 给你一个格式为 "<col1><row1>:<col2><row2>" 的字符串 s ，其中 <col1> 表示 c1 列，<row1> 表示 r1 行，<col2> 表示 c2 列，<row2> 表示 r2 行，
# 并满足 r1 <= r2 且 c1 <= c2 。
#
# 找出所有满足 r1 <= x <= r2 且 c1 <= y <= c2 的单元格，并以列表形式返回。单元格应该按前面描述的格式用 字符串 表示，并以 非递减 顺序排列（先按列排，再按行排）。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/cells-in-a-range-on-an-excel-sheet
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def cellsInRange(self, s: str) -> List[str]:
        s_list = list(s)
        start_col = s_list[0]
        end_col = s_list[3]
        start_row = int(s_list[1])
        end_row = int(s_list[4])

        res = []
        for i in range(ord(start_col), ord(end_col) + 1):
            char_col = chr(i)
            res += [char_col + str(j) for j in range(start_row, end_row + 1)]
        return res


s = Solution()
print(s.cellsInRange("K1:L2"))
