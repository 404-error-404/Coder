#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/11 23:43
# @Remarks  : Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由俄国科学家 Levenshtein 提出的，故又叫 Levenshtein Distance 。
#
# 例如：
#
# 字符串A: abcdefg
#
# 字符串B: abcdef
#
# 通过增加或是删掉字符 ”g” 的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
#
# 要求：
#
# 给定任意两个字符串，写出一个算法计算它们的编辑距离。
#
#
# 数据范围：给定的字符串长度满足 1 \le len(str) \le 1000 \1≤len(str)≤1000
#
# https://www.nowcoder.com/practice/3959837097c7413a961a135d7104c314
s1 = input()
s2 = input()
# n行m列
n = len(s1) + 1
m = len(s2) + 1

dp = [[0] * m for i in range(n)]
for i in range(m):
    dp[0][i] = i
for i in range(n):
    dp[i][0] = i

for i in range(1, n):
    for j in range(1, m):
        if s1[i - 1] == s2[j - 1]:
            dp[i][j] = dp[i - 1][j - 1]
        else:
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
print(dp[-1][-1])
