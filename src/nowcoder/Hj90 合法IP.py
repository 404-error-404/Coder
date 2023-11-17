#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 16:29
# @Remarks  : IPV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此正号不需要出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
#
# 现在需要你用程序来判断IP是否合法。
#
# 数据范围：数据组数：1\le t\le 18\1≤t≤18
# 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
#
# https://www.nowcoder.com/practice/995b8a548827494699dc38c3e2a54ee9
YES = "YES"
NO = "NO"
def judge_ip(ip: str):
    ip = ip.split(".")
    if len(ip) != 4:
        return NO
    for num in ip:
        try:
            n = int(num)
        except ValueError:
            return NO
        if n > 255 or n < 0 or str(n) != num:
            return NO
    return YES


print(judge_ip(input()))
