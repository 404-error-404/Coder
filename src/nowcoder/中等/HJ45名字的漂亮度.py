#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/10 23:38
# @Remarks  : 给出一个字符串，该字符串仅由小写字母组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
# 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
#
# 给出多个字符串，计算每个字符串最大可能的“漂亮度”。
#
# 本题含有多组数据。
#
# 数据范围：输入的名字长度满足 1 \le n \le 10000 \1≤n≤10000
#
# https://www.nowcoder.com/practice/02cb8d3597cf416d9f6ae1b9ddc4fde3
def calculate_name(s: str):
    count = {}
    for c in s:
        count[c] = count.get(c, 0) + 1
    count = list(count.values())
    count.sort(reverse=True)
    res = 0
    for idx in range(len(count)):
        res += count[idx] * (26 - idx)
    return res


n = int(input())
for i in range(n):
    print(calculate_name(input()))
