#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/5/22 10:42
# @desc :
# 给你一个二维整数数组 stockPrices ，其中 stockPrices[i] = [dayi, pricei] 表示股票在 dayi 的价格为 pricei 。
# 折线图 是一个二维平面上的若干个点组成的图，横坐标表示日期，纵坐标表示价格，折线图由相邻的点连接而成。比方说下图是一个例子：
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/minimum-lines-to-represent-a-line-chart
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def minimumLines(self, stockPrices: List[List[int]]) -> int:
        stockPrices.sort()
        print(stockPrices)
        if len(stockPrices) == 1:
            return 0

        res = 1
        x1, y1 = stockPrices[0]
        x2, y2 = stockPrices[1]
        x_diff = x2 - x1
        y_diff = y2 - y1

        x1 = x2
        y1 = y2

        for x2, y2 in stockPrices:
            # 比较斜率
            new_x = x2 - x1
            new_y = y2 - y1

            # 斜率不同
            if new_y * x_diff != new_x * y_diff:
                res += 1
            x_diff = new_x
            y_diff = new_y
            x1 = x2
            y1 = y2
        return res


s = Solution()
ans = s.minimumLines([[1, 1], [2, 2], [3, 3], [4, 5], [5, 7], [6, 6], [7, 5], [8, 4], [9, 4], [10, 4]])
print(ans)
#
# from matplotlib import pyplot as plt
#
# # 设置图片大小
# fig = plt.figure(figsize=(20, 8), dpi=80)  # plt.figure用来设置图像大小，dpi参数调节图片清晰度
# data_ = [[72, 98], [62, 27], [32, 7], [71, 4], [25, 19], [91, 30], [52, 73], [10, 9], [99, 71], [47, 22], [19, 30],
#          [80, 63], [18, 15], [48, 17], [77, 16], [46, 27], [66, 87], [55, 84], [65, 38], [30, 9], [50, 42], [100, 60],
#          [75, 73], [98, 53], [22, 80], [41, 61], [37, 47], [95, 8], [51, 81], [78, 79], [57, 95]]
# data_.sort()
# x = [i[0] for i in data_]
# y = [i[1] for i in data_]
#
# # 绘图
# plt.plot(x, y, label="X3",marker='s')  # 传入x，y绘制出折线图
#
# # 设置x轴刻度
# plt.xticks(x)  # 设置x轴刻度 可以以plt.xticks(range(2,26))的样式来调节x刻度参数
# # 另一种一列表的形式来传递步长
# # _xtick_labels = [i/2 for i in range(4,49)]
# # plt.xticks(_xtick_labels)   同时也可以在这一步里面设置步长plt.xticks(_xtick_labels[::3])
# # 传y的时候 plt.yticks(range(min(y),max(y)+1)) +1以免最后一个取不到 直接最大值最小值 刻度不均匀，range无意义
# # 保存图片
# plt.savefig("./sig_size.png")  # 保存图片 要在绘制之后保存 plt.savefig保存图片 保存为svg这种矢量图，放大不会有锯齿
#
# # 展示图形
# plt.show()  # 在执行程序的同时显示出图形
