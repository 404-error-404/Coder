#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 14:35
# @Remarks  : 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
#
# 矩阵的大小不超过100*100
#
# https://www.nowcoder.com/practice/ebe941260f8c4210aa8c17e99cbc663b
x = int(input())
y = int(input())
z = int(input())
j1 = []
j2 = []
# x行z列
res = [[0] * z for i in range(x)]
for i in range(x):
    j1.append([int(n) for n in input().split(" ")])
for i in range(y):
    j2.append([int(n) for n in input().split(" ")])
for i in range(x):
    for j in range(z):
        tmp1 = j1[i]
        tmp2 = [j2[k][j] for k in range(y)]

        res[i][j] = sum(map(lambda a, b: a * b, tmp1, tmp2))
for row in res:
    for n in row:
        print(n, end=" ")
    print()
