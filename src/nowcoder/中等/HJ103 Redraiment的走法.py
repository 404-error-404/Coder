#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/14 17:44
# @Remarks  : Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
#
# 数据范围：每组数据长度满足 1 \le n \le 200 \1≤n≤200  ， 数据大小满足 1 \le val \le 350 \1≤val≤350
#
# https://www.nowcoder.com/practice/24e6243b9f0446b081b1d6d32f2aa3aa
n = int(input())
nums = [int(i) for i in input().split(" ")]
count = [1] * n
res = 1
for i in range(1, n):
    for j in range(i):
        if nums[j] < nums[i]:
            count[i] = max(count[i], count[j] + 1)
    res = max(res, count[i])
print(res)