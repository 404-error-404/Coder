#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/9 15:59
# @Remarks  : 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
#
# 输入：
#
# 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
#
# 坐标之间以;分隔。
#
# 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
#
# 下面是一个简单的例子 如：
#
# A10;S20;W10;D30;X;A1A;B10A11;;A10;
#
# 处理过程：
#
# 起点（0,0）
#
# +   A10   =  （-10,0）
#
# +   S20   =  (-10,-20)
#
# +   W10  =  (-10,-10)
#
# +   D30  =  (20,-10)
#
# +   x    =  无效
#
# +   A1A   =  无效
#
# +   B10A11   =  无效
#
# +  一个空 不影响
#
# +   A10  =  (10,-10)
#
# 结果 （10， -10）
#
# 数据范围：每组输入的字符串长度满足 1\le n \le 10000 \1≤n≤10000  ，坐标保证满足 -2^{31} \le x,y \le 2^{31}-1 \−2
# 31
#  ≤x,y≤2
# 31
#  −1  ，且数字部分仅含正数
#
# https://www.nowcoder.com/practice/119bcca3befb405fbe58abe9c532eb29

def str_to_xy(raw_xy: str):
    if len(raw_xy) <= 1:
        return None

    # 首先判断方向
    base = [0, 0]
    if raw_xy[0] == "A":
        base[0] = -1
    elif raw_xy[0] == "D":
        base[0] = 1
    elif raw_xy[0] == "W":
        base[1] = 1
    elif raw_xy[0] == "S":
        base[1] = -1
    else:
        return None

    raw_xy = raw_xy[1:]
    # 检测剩下的是否全部为数字
    for r in raw_xy:
        if not ("0" <= r <= "9"):
            return None
    count = int(raw_xy)
    base[0] *= count
    base[1] *= count
    return base


s = map(str_to_xy, input().split(";"))
location = [0, 0]
for xy in s:
    if xy is not  None:
        location[0] += xy[0]
        location[1] += xy[1]
print(str(location[0]) + "," + str(location[1]))
