#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/24 23:26
# @Remarks  :
# 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个3X3粗线宫内的数字均含1-9，并且不重复。
#
# 数据范围：输入一个 9*9 的矩阵
#
# https://www.nowcoder.com/practice/78a1a4ebe8a34c93aac006c44f6bf8a1
nums = []
for _ in range(9):
    nums.append([int(i) for i in input().split(" ")])
row_set = [set() for _ in range(9)]
col_set = [set() for _ in range(9)]
full_set = {1, 2, 3, 4, 5, 6, 7, 8, 9}
to_calculate = []
for i in range(9):
    for j in range(9):
        if nums[i][j] == 0:
            to_calculate.append((i, j))
        else:
            row_set[i].add(nums[i][j])
            col_set[j].add((nums[i][j]))


def get_candidate(x, y):
    # 获得其所在9宫格的数字
    grid_9 = set()
    top_x = x // 3 * 3
    top_y = y // 3 * 3
    for tmp_x in range(top_x, top_x + 3):
        for tmp_y in range(top_y, top_y + 3):
            grid_9.add(nums[tmp_x][tmp_y])
    return full_set - (row_set[i] | col_set[j] | grid_9)


candidate = {}
flag = True
while flag:
    to_remove = []
    for i, j in to_calculate:
        tmp = get_candidate(i, j)
        if len(tmp) == 1:
            nums[i][j] = tmp.pop()
            row_set[i].add(nums[i][j])
            col_set[j].add(nums[i][j])
            to_remove.append((i, j))
        else:
            candidate[(i, j)] = tmp
    for tmp in to_remove:
        to_calculate.remove(tmp)
    flag = len(to_remove) == 0


# 回溯逐渐确定
def is_valid(x, y, num):
    grid_9 = set()
    top_x = x // 3 * 3
    top_y = y // 3 * 3
    for tmp_x in range(top_x, top_x + 3):
        for tmp_y in range(top_y, top_y + 3):
            if num == nums[tmp_x][tmp_y]:
                return False
    for i in range(9):
        if num == nums[i][y] or num == nums[x][i]:
            return False
    return True


def dfs(idx: int):
    if idx == len(to_calculate):
        return True
    x, y = to_calculate[idx]
    for n in candidate[(x, y)]:
        if is_valid(x, y, n):
            nums[x][y] = n
            if dfs(idx + 1):
                return True
    nums[x][y] = 0
    return False


dfs(0)
for row in nums:
    for i in row:
        print(i, end=" ")
    print()
# 0 9 5 0 2 0 0 6 0
# 0 0 7 1 0 3 9 0 2
# 6 0 0 0 0 5 3 0 4
# 0 4 0 0 1 0 6 0 7
# 5 0 0 2 0 7 0 0 9
# 7 0 3 0 9 0 0 2 0
# 0 0 9 8 0 0 0 0 6
# 8 0 6 3 0 2 1 0 5
# 0 5 0 0 7 0 2 8 3
