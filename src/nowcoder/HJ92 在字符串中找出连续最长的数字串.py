#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 23:54
# @Remarks  : 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
# 本题含有多组样例输入。
#
# 数据范围：字符串长度 1 \le n \le 200 \1≤n≤200  ， 保证每组输入都至少含有一个数字
#
# https://www.nowcoder.com/practice/2c81f88ecd5a4cc395b5308a99afbbec
import sys

nums = []
res = []
max_len = 0


def cal_str(s: str):
    global max_len
    nums.clear()
    res.clear()
    max_len = 0
    def nums_to_str():
        global max_len
        if len(nums) > max_len:
            res.clear()
            max_len = len(nums)
            res.append("".join(nums))
        elif len(nums) == max_len:
            res.append("".join(nums))
        nums.clear()

    for c in s:
        if "0" <= c <= "9":
            nums.append(c)
        else:
            nums_to_str()
    nums_to_str()
    return res, max_len


for line in sys.stdin:
    nums_list, length = cal_str(line.strip())
    print("".join(nums_list) + "," + str(length))
