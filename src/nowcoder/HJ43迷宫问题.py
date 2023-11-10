#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/10 23:06
# @Remarks  : 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
#
#
# int maze[5][5] = {
# 0, 1, 0, 0, 0,
# 0, 1, 1, 1, 0,
# 0, 0, 0, 0, 0,
# 0, 1, 1, 1, 0,
# 0, 0, 0, 1, 0,
# };
#
#
# 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
#
#
# 数据范围： 2 \le n,m \le 10 \2≤n,m≤10  ， 输入的内容只包含 0 \le val \le 1 \0≤val≤1
#
# https://www.nowcoder.com/practice/cf24906056f4488c9ddb132f317e03bc
# n行m列
n, m = map(int, input().split(" "))
grid = []
for i in range(n):
    grid.append([int(j) for j in input().split(" ")])


def get_round_xy(_x, _y):
    res = []
    if _x > 0:
        res.append([_x - 1, _y])
    if _y > 0:
        res.append([_x, _y - 1])
    if _x < n - 1:
        res.append([_x + 1, _y])
    if _y < m - 1:
        res.append([_x, _y + 1])
    return res


cur_list = [[0, 0]]
next_list = []
while len(cur_list) != 0:
    for x, y in cur_list:
        if x == n - 1 and y == m - 1:
            break
        for next_x, next_y in get_round_xy(x, y):
            if grid[next_x][next_y] == 0:
                next_list.append([next_x, next_y])
                grid[next_x][next_y] = [x, y]
    cur_list = next_list
    next_list = []


def print_xy(_x, _y):
    if _x == 0 and _y == 0:
        print(f"({_x},{_y})")
        return
    print_xy(grid[_x][_y][0], grid[_x][_y][1])
    print(f"({_x},{_y})")


print_xy(n - 1, m - 1)
