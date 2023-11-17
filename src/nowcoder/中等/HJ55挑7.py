#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 0:01
# @Remarks  : 输出 1到n之间 的与 7 有关数字的个数。
# 一个数与7有关是指这个数是 7 的倍数，或者是包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）
#
# 数据范围： 1 \le n \le 30000 \1≤n≤30000
#
# https://www.nowcoder.com/practice/ba241b85371c409ea01ac0aa1a8d957b
res = 0
# 7的倍数
# 包含7
n = int(input())
for i in range(1, n):
    if i % 7 == 0 or "7" in str(i):
        res += 1
print(res)


