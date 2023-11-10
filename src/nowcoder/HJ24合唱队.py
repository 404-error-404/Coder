#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/9 16:30
# @Remarks  :
# N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
#
# 设KK位同学从左到右依次编号为 1，2…，K ，他们的身高分别为T_1,T_2,…,T_KT
# 1
# ​
#  ,T
# 2
# ​
#  ,…,T
# K
# ​
#   ，若存在i(1\leq i\leq K)i(1≤i≤K) 使得T_1<T_2<......<T_{i-1}<T_iT
# 1
# ​
#  <T
# 2
# ​
#  <......<T
# i−1
# ​
#  <T
# i
# ​
#   且 T_i>T_{i+1}>......>T_KT
# i
# ​
#  >T
# i+1
# ​
#  >......>T
# K
# ​
#  ，则称这KK名同学排成了合唱队形。
# 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
# 例子：
# 123 124 125 123 121 是一个合唱队形
# 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
# 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
#
# 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
#
# 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
#
# 数据范围： 1 \le n \le 3000 \1≤n≤3000
#
# https://www.nowcoder.com/practice/6d9d69e3898f45169a441632b325c7b4
from typing import List


def generate_left(high: List[int]) -> List[int]:
    left = [1] * n
    for i in range(1, n):
        for j in range(i):
            if high[j] < high[i] and left[j] >= left[i]:
                left[i] = left[j] + 1
    return left

n = int(input())
_high = [int(i) for i in input().split(" ")]
count = generate_left(_high)
count2 = generate_left(_high[::-1])[::-1]
print(count)
print(count2)
for i in range(n):
    count[i] =  count[i] + count2[i] - 1
print(n - max(count))
