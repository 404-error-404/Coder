#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/20 18:12
# @Remarks  : 给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,相同成绩
#
# 都按先录入排列在前的规则处理。
#
# 例示：
# jack      70
# peter     96
# Tom       70
# smith     67
#
# 从高到低  成绩
# peter     96
# jack      70
# Tom       70
# smith     67
#
# 从低到高
#
# smith     67
#
# jack      70
#
# Tom       70
# peter     96
#
# 注：0代表从高到低，1代表从低到高
#
# 数据范围：人数：1\le n \le 200\1≤n≤200
# 进阶：时间复杂度：O(nlogn)\O(nlogn) ，空间复杂度：O(n)\O(n)
#
# https://www.nowcoder.com/practice/8e400fd9905747e4acc2aeed7240978b
n = int(input())
if_reverse = input() == "0"
people = []
for i in range(n):
    people.append(input().split(" "))
people.sort(key=lambda p: int(p[1]), reverse=if_reverse)
for p in people:
    print(" ".join(p))
