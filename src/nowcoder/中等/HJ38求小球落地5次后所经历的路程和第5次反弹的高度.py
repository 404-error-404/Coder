#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/10 22:46
# @Remarks  : 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
#
#
# 数据范围：输入的小球初始高度满足 1 \le n \le 1000 \1≤n≤1000  ，且保证是一个整数
#
# https://www.nowcoder.com/practice/2f6f9339d151410583459847ecc98446
def get_high(high, count):

    if count == 1:
        return high
    else:
        return high + high /2 + get_high(high / 2, count-1)

start = int(input())
print(get_high(start, 5))
print(start / 32)
