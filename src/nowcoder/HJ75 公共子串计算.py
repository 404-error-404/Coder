#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/13 0:06
# @Remarks  : 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
#
# 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
# 数据范围：字符串长度：1\le s\le 150\1≤s≤150
# 进阶：时间复杂度：O(n^3)\O(n
# 3
#  ) ，空间复杂度：O(n)\O(n)
#
# https://www.nowcoder.com/practice/98dc82c094e043ccb7e0570e5342dd1b
s1 = input()
s2 = input()
m = len(s1)
n = len(s2)
# m+1行n+1列
dp = [[0] * (n + 1) for i in range(m + 1)]
res = 0
for i in range(1, m + 1):
    for j in range(1, n + 1):
        if s1[i - 1] == s2[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
            res = max(res, dp[i][j])

print(res)
