#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/4/30 22:27
# @desc :
# 给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，其中 guards[i] = [rowi, coli] 且 walls[j] = [rowj, colj] ，分别表示第 i 个警卫和第 j 座墙所在的位置。
# 
# 一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。如果一个格子能被 至少 一个警卫看到，那么我们说这个格子被 保卫 了。
# 
# 请你返回空格子中，有多少个格子是 没被保卫 的。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/count-unguarded-cells-in-the-grid
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        # 最后一列记录当前行查找的最右侧的墙
        # 最后一列记录当前列查找的最下方格子
        grids = [[0] * n for j in range(m)]
        # 该单元格横向和纵向的搜索状态
        grids_status = [[[0] * 2 for _ in range(n)] for j in range(m)]
        for w in walls:
            grids[w[0]][w[1]] = -1
        for g in guards:
            grids[g[0]][g[1]] = 1
            # 上下左右遍历
            for x in range(g[0] - 1, -1, -1):
                if grids[x][g[1]] == 1 or grids[x][g[1]] == -1 or grids_status[x][g[1]][1] == 1:
                    break
                else:
                    grids[x][g[1]] = 2
                    grids_status[x][g[1]][1] = 1
            for x in range(g[0] + 1, m):
                if grids[x][g[1]] == 1 or grids[x][g[1]] == -1 or grids_status[x][g[1]][1] == 1:
                    break
                else:
                    grids[x][g[1]] = 2
                    grids_status[x][g[1]][1] = 1
            for y in range(g[1] - 1, -1, -1):
                if grids[g[0]][y] == 1 or grids[g[0]][y] == -1 or grids_status[g[0]][y][0] == 1:
                    break
                else:
                    grids[g[0]][y] = 2
                    grids_status[g[0]][y][0] = 1
            for y in range(g[1] + 1, n):
                if grids[g[0]][y] == 1 or grids[g[0]][y] == -1 or grids_status[g[0]][y][0] == 1:
                    break
                else:
                    grids[g[0]][y] = 2
                    grids_status[g[0]][y][0] = 1
        count = 0
        for x in range(m):
            for y in range(n):
                if grids[x][y] == 0:
                    count += 1
        return count


s = Solution()
m = 4
n = 6
g = [[0, 0], [1, 1], [2, 3]]
w = [[0, 1], [2, 2], [1, 4]]
ans = s.countUnguarded(m, n, g, w)
print(ans)
