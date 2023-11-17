#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/14 0:15
# @Remarks  : 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
# 注：真分数指分子小于分母的分数，分子和分母有可能gcd不为1！
# 如有多个解，请输出任意一个。
#
# https://www.nowcoder.com/practice/e0480b2c6aa24bfba0935ffcca3ccb7b
import sys
from typing import List

# 数学题，下边的做法超时
# def get_sub(x1: int, y1: int, x2: int, y2: int):
#     """
#     真分数做减法
#     :param x1: 数1的分子
#     :param y1: 数1的分母
#     :param x2: 数2的分子
#     :param y2: 数2的分母
#     :return: (x, y): (分子， 分母)
#     """
#     # 比较大小
#     # 通分
#     new_x = x1 * y2 - x2 * y1
#     if new_x < 0:
#         return None, None
#     elif new_x == 0:
#         return 0, 0
#     return new_x, y1 * y2
#
#
# def solution(x: int, y: int):
#     res = []
#     count = 2
#     while x != 0:
#         new_x, new_y = get_sub(x, y, 1, count)
#         if new_x is None:
#             count += 1
#             continue
#         res.append(count)
#         x = new_x
#         y = new_y
#         count += 1
#     return res
#
#
def print_ans(ans: List[int]):
    ans = [f"1/{i}" for i in ans]
    print("+".join(ans))


def egyptian_fraction(x, y):
    res = []
    while y % x != 0:
        c = y // x + 1
        res.append(c)
        x = x * c - y
        y = y * c
    res.append(y // x)
    return res

for line in sys.stdin:
    a, b = map(int, line.strip().split("/"))
    print_ans(egyptian_fraction(a, b))
    # print_ans(solution(a, b)) # 超时
