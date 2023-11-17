#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/10 17:34
# @Remarks  : Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
#
# 数据范围：字符串长度满足 1 \le n \le 2500 \1≤n≤2500
#
# https://www.nowcoder.com/practice/3cd4621963e8454594f00199f4536bb1
s = list(input())
dp = [[0] * len(s) for i in range(len(s))]
for i in range(len(s)):
    dp[i][i] = 1

res = 1

for i in range(len(s) - 1):
    if s[i] == s[i + 1]:
        dp[i][i + 1] = 1
        res = 2
n = len(s)

# 根据长度向后遍历
for sub_len in range(3, n + 1):
    for l in range(n - sub_len + 1):
        r = l + sub_len - 1
        if s[l] == s[r] and dp[l + 1][r - 1] == 1:
            dp[l][r] = 1
            res = max(res, r - l + 1)
print(res)

"""
下边是常规做法
s = list(input())
dp = [[0] * len(s) for i in range(len(s))]
for i in range(len(s)):
    dp[i][i] = 1
res = 1
n = len(s)
for r in range(1, n):
    for l in range(r):
        if s[l] == s[r] and (r - l <= 2 or dp[l + 1][r - 1] == 1):
            dp[l][r] = 1
            res = max(res, r - l + 1)
print(res)
"""