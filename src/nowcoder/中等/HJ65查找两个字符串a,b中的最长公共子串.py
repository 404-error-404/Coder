#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 12:20
# @Remarks  : 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
# 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
#
# 数据范围：字符串长度1\le length \le300 \1≤length≤300
# 进阶：时间复杂度：O(n^3)\O(n
# 3
#  ) ，空间复杂度：O(n)\O(n)
#
# https://www.nowcoder.com/practice/181a1a71c7574266ad07f9739f791506
s1 = input()
s2 = input()
# s1存储较短串，s2存储较长串8
if len(s1) > len(s2):
    s1, s2 = s2, s1


def get_sub_s():
    len1 = len(s1)
    for n in range(len1, 0, -1):
        for idx in range(0, len1 - n + 1):
            tmp = s1[idx: idx + n]
            if tmp in s2:
                return tmp
    return ""


print(get_sub_s())


# 动态规划做法
def dp_res():
    n = len(s1)
    m = len(s2)
    dp = [[0] * (m + 1) for i in range(n + 1)]
    idx = 0
    max_len = 0
    for i in range(n):
        for j in range(m):
            if s1[i] == s2[j]:
                dp[i + 1][j + 1] = dp[i][j] + 1
                if dp[i + 1][j + 1] > max_len:
                    max_len = dp[i + 1][j + 1]
                    idx = i
    return s1[idx - max_len + 1:idx + 1]
print(dp_res())
