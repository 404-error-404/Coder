#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 15:09
# @Remarks  : 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
# 要求：
# 实现如下2个通配符：
# *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
# ？：匹配1个字符
#
# 注意：匹配时不区分大小写。
#
# https://www.nowcoder.com/practice/43072d50a6eb44d2a6c816a283b02036
# pattern = input()
# s = input()

# ** → *
# *? → *

def re_match(pattern: str, s: str):
    p_len = len(pattern)
    s_len = len(s)
    if p_len == 0:
        return s_len == p_len
    for idx in range(p_len):
        p: str = pattern[idx]
        if p == "?":
            if idx >= s_len:
                return False
            else:
                pattern = pattern[idx + 1:]
                res = re_match(pattern, s[idx:])
                if idx <= s_len - 1:
                    res = res or re_match(pattern, s[idx + 1:])
                return res
        elif p == "*":
            # 正则表达式以*结尾
            if idx == p_len - 1:
                return True
            else:
                next_c = pattern[idx + 1]
                next_c_pos = s.find(next_c, idx)
                while next_c_pos > -1:
                    if re_match(pattern[idx + 1:], s[next_c_pos:]):
                        return True
                    else:
                        next_c_pos = s.find(next_c, next_c_pos + 1)
                return False
        elif idx >= s_len or p != s[idx]:
            return False
    return p_len == s_len


s1 = input().lower()
while "**" in s1:
    s1 = s1.replace("**", "*")
while "*?" in s1:
    s1 = s1.replace("*?", "*")
while "?*" in s1:
    s1 = s1.replace("?*", "*")
s2 = input().lower()
if re_match(s1, s2):
    print("true")
else:
    print("false")
