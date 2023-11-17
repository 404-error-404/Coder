#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/13 21:53
# @Remarks  : 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
# 要求输出所有火车出站的方案，以字典序排序输出。
# 数据范围：1\le n\le 10\1≤n≤10
# 进阶：时间复杂度：O(n!)\O(n!) ，空间复杂度：O(n)\O(n)
#
# https://www.nowcoder.com/practice/97ba57c35e9f4749826dc3befaeae109
from typing import List

n = int(input())
train_list = [int(i) for i in input().split(" ")]

res = []
# 对栈来说，每一步有两种可能：入栈，出栈
def operation(stack: List[int], trains: List[int], idx, cur_order: List[int]):
    if len(cur_order) == len(trains):
        res.append(cur_order.copy())
    # 出栈
    if len(stack) != 0:
        t = stack.pop(-1)
        cur_order.append(t)
        operation(stack, trains, idx, cur_order)
        # 还原
        cur_order.pop(-1)
        stack.append(t)
    # 入栈
    if idx < len(trains):
        stack.append(trains[idx])
        operation(stack, trains, idx + 1, cur_order)
        # 还原
        stack.pop(-1)


operation([], train_list, 0, [])
res.sort()
for l in res:
    for n in l:
        print(n, end=" ")
    print()
