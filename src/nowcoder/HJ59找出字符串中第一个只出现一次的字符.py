#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 0:15
# @Remarks  : 找出字符串中第一个只出现一次的字符
#
#
# 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
#
# https://www.nowcoder.com/practice/e896d0f82f1246a3aa7b232ce38029d4

def find_c(s: str):
    record = set()
    for idx in range(len(s)):
        c = s[idx]
        if c in record:
            continue
        elif s.find(c, idx+1) == -1:
            return c
        else:
            record.add(c)
    return -1
print(find_c(input()))