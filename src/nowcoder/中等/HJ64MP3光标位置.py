#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 12:09
# @Remarks  : MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
#
#
# 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
#
# 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
#
# 光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
#
#
#
# 其他情况下用户按Up键，光标挪到上一首歌曲；用户按Down键，光标挪到下一首歌曲。
#
#
#
# 2. 歌曲总数大于4的时候（以一共有10首歌为例）：
#
#
# 特殊翻页：屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。
#
#
#
# 一般翻页：屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按Up键后，屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。光标当前屏幕的最后一首歌时的Down键处理也类似。
#
#
#
# 其他情况，不用翻页，只是挪动光标就行。
#
# 数据范围：命令长度1\le s\le 100\1≤s≤100 ，歌曲数量1\le n \le 150\1≤n≤150
# 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
#
# https://www.nowcoder.com/practice/eaf5b886bd6645dd9cfb5406f3753e15
n = int(input())
s = input()
idx = 1
cur_list = [i + 1 for i in range(min(4, n))]
for c in s:
    if c == "U":
        idx -= 1
        if idx == 0:
            idx = n
            cur_list = [n - i for i in range(min(4, n))]
            cur_list.reverse()
        else:
            if idx not in cur_list:
                cur_list.pop(3)
                cur_list.insert(0, idx)
    else:
        idx += 1
        if idx > n:
            idx = 1
            cur_list = [i + 1 for i in range(min(4, n))]
        else:
            if idx not in cur_list:
                cur_list.pop(0)
                cur_list.append(idx)
for i in cur_list:
    print(i, end=" ")
print()
print(idx)
