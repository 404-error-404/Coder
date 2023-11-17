#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/10/30 17:17
# @Remarks  : 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
#
# 数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n≤2
# 31
#  −1
# 输入描述：
# 输入一个十六进制的数值字符串。
#
# 输出描述：
# 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
res = 0
num = input()[2:]
for c in num:
    if ord("Z") >= ord(c) >= ord("A"):
        res = res * 16 + ord(c) - ord("A") + 10
    elif ord("z") >= ord(c) >= ord("a"):
        res = res * 16 + ord(c) - ord("a") + 10
    else:
        res += int(c)