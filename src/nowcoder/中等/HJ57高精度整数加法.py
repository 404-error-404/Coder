#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 0:05
# @Remarks  : 输入两个用字符串 str 表示的整数，求它们所表示的数之和。
#
# 数据范围： 1 \le len(str) \le 10000 \1≤len(str)≤10000
#
# https://www.nowcoder.com/practice/49e772ab08994a96980f9618892e55b6
# n1 = int(input())
# n2 = int(input())
# print(n1 + n2)
# 常规做法
n1 = [int(i) for i in input()[::-1]]
n2 = [int(i) for i in input()[::-1]]
n1_len = len(n1)
n2_len = len(n2)
max_len = max(n1_len, n2_len) + 1
n1 = n1 + [0] * (max_len - n1_len)
n2 = n2 + [0] * (max_len - n2_len)

base = 0
for i in range(max_len):
    tmp = n1[i] + n2[i] + base
    base = tmp // 10
    n1[i] = tmp % 10
if n1[-1] == 0:
    n1.pop(-1)
for n in n1[::-1]:
    print(n, end="")