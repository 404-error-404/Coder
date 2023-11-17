#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/14 17:45
# @Remarks  : 计算一个浮点数的立方根，不使用库函数。
# 保留一位小数。
#
# 数据范围：|val| \le 20 \∣val∣≤20
#
# https://www.nowcoder.com/practice/caf35ae421194a1090c22fe223357dca
n = float(input())

l = -20.0
r = 20.0
while (r - l) > 0.000000000001:
    mid = (l + r) / 2
    if mid ** 3 > n:
        r = mid
    else:
        l = mid

print("%.1f" % r)
print(l, r)
