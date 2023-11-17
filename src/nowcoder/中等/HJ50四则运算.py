#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/11 16:07
# @Remarks  : 输入一个表达式（用字符串表示），求这个表达式的值。
# 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
#
# 数据范围：表达式计算结果和过程中满足 |val| \le 1000 \∣val∣≤1000  ，字符串长度满足 1 \le n \le 1000 \1≤n≤1000
#
# https://www.nowcoder.com/practice/9999764a61484d819056f807d2a91f1e
from typing import List

s = (input()
     .replace("[", "(")
     .replace("{", "(")
     .replace("]", ")")
     .replace("}", ")"))
s_list = []
last_c = True
tmp = []
for c in s:
    if "0" <= c <= "9":
        last_c = False
        tmp.append(c)
    elif c == "-" and last_c:
        tmp.append(c)
    else:
        if c != ")":
            last_c = True
        if tmp:
            s_list.append(int("".join(tmp)))
            tmp.clear()
        s_list.append(c)
if tmp:
    s_list.append(int("".join(tmp)))


def calculate(sub_s: List):
    # 去括号
    l = "("
    r = ")"
    while l in sub_s:
        end = sub_s.index(r)
        for idx in range(end, -1, -1):
            if sub_s[idx] == l:
                start = idx
                break
        val = calculate(sub_s[start + 1: end])
        for i in range(end, start - 1, -1):
            sub_s.pop(i)
        sub_s.insert(start, val)
    # 算乘除
    idx = 0
    while idx < len(sub_s):
        if sub_s[idx] == "*" or sub_s[idx] == "/":
            l = sub_s[idx - 1]
            r = sub_s[idx + 1]
            if sub_s[idx] == "*":
                val = l * r
            else:
                val = l // r
            sub_s.pop(idx)
            sub_s.pop(idx)
            sub_s[idx - 1] = val
        else:
            idx += 1
    # 算加减
    return plus_and_sub(sub_s)


def plus_and_sub(sub_s: List):
    res = sub_s[0]
    for idx in range(1, len(sub_s), 2):
        if sub_s[idx] == "+":
            res += sub_s[idx + 1]
        else:
            res -= sub_s[idx + 1]
    return res


print(calculate(s_list))
# (7 + 4 * 3 + 10 * (3 - 3 + 4 - 1 - 8 - 10))
