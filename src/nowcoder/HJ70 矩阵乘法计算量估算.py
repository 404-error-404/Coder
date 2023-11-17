#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 14:46
# @Remarks  : 矩阵乘法的运算量与矩阵乘法的顺序强相关。
# 例如：
#
# A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
#
# 计算A*B*C有两种顺序：((AB)C)或者(A(BC))，前者需要计算15000次乘法，后者只需要3500次。
#
# 编写程序计算不同的计算顺序需要进行的乘法次数。
#
# 数据范围：矩阵个数：1\le n\le 15 \1≤n≤15 ，行列数：1\le row_i,col_i\le 100\1≤row
# i
# ​
#  ,col
# i
# ​
#  ≤100 ，保证给出的字符串表示的计算顺序唯一。
# 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
#
# https://www.nowcoder.com/practice/15e41630514445719a942e004edc0a5b
from typing import List

n = int(input())
matrix = []
for i in range(n):
    x, y = map(int, input().split(" "))
    matrix.append([x, y])

res = []
base = ord("A")
for c in input():
    if c == "(" or c == ")":
        res.append(c)
    else:
        res.append(matrix[ord(c) - base])

ans = 0


# 寻找括号，开始计算
def calculate(m_list: List):
    global ans
    if len(m_list) < 2:
        return m_list
    while ")" in m_list:
        end = m_list.index(")")
        start = 0
        for idx in range(end - 1, -1, -1):
            if m_list[idx] == "(":
                start = idx
                break
        val = calculate(m_list[start + 1:end])
        for idx in range(start, end + 1):
            m_list.pop(start)
        m_list.insert(start, val)
    cur = m_list[0]
    for m in m_list[1:]:
        row = cur[0]
        col = m[1]
        count = cur[1]
        ans += row * col * count
        cur[1] = col

    return cur


calculate(res)
print(ans)
