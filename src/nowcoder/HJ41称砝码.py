#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/10 22:46
# @Remarks  : 现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
# 每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
#
#
# 注：
#
# 称重重量包括 0
#
# 数据范围：每组输入数据满足 1 \le n \le 10 \1≤n≤10  ， 1 \le m_i \le 2000 \1≤m
# i
# ​
#  ≤2000  ， 1 \le x_i \le 10 \1≤x
# i
# ​
#  ≤10
#
# https://www.nowcoder.com/practice/f9a4c19050fc477e9e27eb75f3bfd49c
res = set()
res.add(0)
n = int(input())
s1 = input()
s2 = input()
weight = [int(i) for i in s1.split(" ")]
count = [int(i) for i in s2.split(" ")]
print(weight)
print(count[1])
for i in range(n):
    w = weight[i]
    for c in range(count[i]):
        res_copy = res.copy()
        for r in res_copy:
            res.add(r + w)
print(len(res))
