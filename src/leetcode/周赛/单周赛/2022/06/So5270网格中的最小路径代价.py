#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/6/12 16:15
# @desc :
# 给你一个下标从 0 开始的整数矩阵 grid ，矩阵大小为 m x n ，由从 0 到 m * n - 1 的不同整数组成。
# 你可以在此矩阵中，从一个单元格移动到 下一行 的任何其他单元格。
# 如果你位于单元格 (x, y) ，且满足 x < m - 1 ，你可以移动到 (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1) 中的任何一个单元格。
# 注意： 在最后一行中的单元格不能触发移动。
# 
# 每次可能的移动都需要付出对应的代价，代价用一个下标从 0 开始的二维数组 moveCost 表示，该数组大小为 (m * n) x n ，
# 其中 moveCost[i][j] 是从值为 i 的单元格移动到下一行第 j 列单元格的代价。从 grid 最后一行的单元格移动的代价可以忽略。
# 
# grid 一条路径的代价是：所有路径经过的单元格的 值之和 加上 所有移动的 代价之和 。从 第一行 任意单元格出发，返回到达 最后一行 任意单元格的最小路径代价。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/minimum-path-cost-in-a-grid
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def minPathCost(self, grid: List[List[int]], moveCost: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        cur_cost = grid[0]

        for g_idx in range(m - 1):
            next_cost = [1000000] * n
            for idx, num in enumerate(grid[g_idx]):
                for i in range(n):
                    next_cost[i] = min(cur_cost[idx] + moveCost[num][i] + grid[g_idx + 1][i], next_cost[i])
            cur_cost = next_cost

        return min(cur_cost)


grid = [[5, 3], [4, 0], [2, 1]]
moveCost = [[9, 8], [1, 5], [10, 12], [18, 6], [2, 4], [14, 3]]
s = Solution()
print(s.minPathCost(grid, moveCost))
