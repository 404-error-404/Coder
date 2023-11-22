#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/22 22:11
# @Remarks  : 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
#
# 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
#
# 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
#
# 详细说明：
#
# 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，没有括号，友情提醒，整数除法要当心，是属于整除，比如2/3=0，3/2=1；
# 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
# 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
# 4.输出的算式格式为4张牌通过+-*/四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
# 5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24，2 A 9 A不能变为(2+1)*(9-1)=24
# 6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
# 7.因为都是扑克牌，不存在单个牌为0的情况，且没有括号运算，除数(即分母)的数字不可能为0
#
# 数据范围：一行由4张牌组成的字符串
#
# https://www.nowcoder.com/practice/7e124483271e4c979a82eb2956544f9d
from typing import List

s = input().upper()
if "JOKER" in s:
    print("ERROR")
    exit(0)
value_map = {
    "A": 1,
    "J": 11,
    "Q": 12,
    "K": 13,
    "2": 2,
    "3": 3,
    "4": 4,
    "5": 5,
    "6": 6,
    "7": 7,
    "8": 8,
    "9": 9,
    "10": 10
}
key_map = {
    1 :"A",
    11 :"J",
    12 :"Q",
    13 :"K",
    2 :"2",
    3 :"3",
    4 :"4",
    5 :"5",
    6 :"6",
    7 :"7",
    8 :"8",
    9 :"9",
    10 :"10",
    "+": "+",
    "-": "-",
    "*": "*",
    "/": "/"
}
s = [value_map[k] for k in s.split(" ")]
del value_map

res = []


def dfs(val: int, nums: List[int]):
    if len(nums) == 0:
        return val == 24
    for n in set(nums):
        tmp = nums.copy()
        tmp.remove(n)
        # 加减乘除
        if dfs(val + n, tmp):
            res.insert(0, n)
            res.insert(0, "+")
            return True
        if dfs(val - n, tmp):
            res.insert(0, n)
            res.insert(0, "-")
            return True
        if dfs(val * n, tmp):
            res.insert(0, n)
            res.insert(0, "*")
            return True
        if val % n == 0:
            if dfs(val // n, tmp):
                res.insert(0, n)
                res.insert(0, "/")
                return True
    return False


for i in set(s):
    sc = s.copy()
    sc.remove(i)
    if dfs(i, sc):
        res.insert(0, i)
        break
if res:
    for i in res:
        print(key_map[i], end="")
else:
    print("NONE")
