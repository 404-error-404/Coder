#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/10/30 17:10
# @Remarks  : •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
#
# •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
# 输入描述：
# 连续输入字符串(每个字符串长度小于等于100)
#
# 输出描述：
# 依次输出所有分割后的长度为8的新字符串
s = input()
tmp = len(s) % 8
if tmp != 0:
    s += "0" * (8 - len(s) % 8)
last_idx = len(s) - 8
idx = 0
while idx <= last_idx:
    print(s[idx: idx + 8])
    idx += 8
