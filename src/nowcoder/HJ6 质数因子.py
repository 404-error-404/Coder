#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/10/30 17:28
# @Remarks  : 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
#
#
# 数据范围： 1 \le n \le 2 \times 10^{9} + 14 \1≤n≤2×10
# 9
#  +14
# 输入描述：
# 输入一个整数
#
# 输出描述：
# 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。

MAX = 2000000014

num = int(input())
for i in range(2, int(pow(num, 0.5)) + 1):
    while num % i == 0:
        print(i, end=" ")
        num = num // i
        if num == 1:
            break
if num != 1:
    print(num)