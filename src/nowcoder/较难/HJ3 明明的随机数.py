#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/17 21:40
# @Remarks  : 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
#
# 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，输入的数字大小满足 1 \le val \le 500 \1≤val≤500
#
# https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0
n = int(input())
nums = set()
for i in range(n):
    nums.add(int(input()))
nums = list(nums)
nums.sort()
for i in nums:
    print(i)
