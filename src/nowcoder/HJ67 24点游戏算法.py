#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 13:37
# @Remarks  : 给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,运算符仅允许出现在两个数字之间,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且需考虑括号运算
# 此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
#
# https://www.nowcoder.com/practice/fbc417f314f745b1978fc751a54ac8cb
from typing import List


# 1对3 4种情况
# 2对2 3种情况
def get_combination_2(x: int, y: int):
    res = {x + y, x - y, y - x, x * y}
    if y != 0 and x % y == 0:
        res.add(x // y)
    if x != 0 and y % x == 0:
        res.add(y // x)
    return res


def get_combination_3(x: int, y: int, z: int):
    res = set()
    for n in get_combination_2(y, z):
        res |= get_combination_2(x, n)
    for n in get_combination_2(x, z):
        res |= get_combination_2(y, n)
    for n in get_combination_2(x, y):
        res |= get_combination_2(z, n)
    return res


def get_combination_4(nums: List[int]):
    # 1对3
    for n in nums:
        tmp = nums.copy()
        tmp.remove(n)
        for nn in get_combination_3(tmp[0], tmp[1], tmp[2]):
            if 24 in get_combination_2(n, nn):
                return "true"
    # 2对2
    n1 = nums[0]
    nums.remove(n1)
    for n2 in nums:
        tmp = nums.copy()
        tmp.remove(n2)
        n3, n4 = tmp
        set1 = get_combination_2(n1, n2)
        set2 = get_combination_2(n3, n4)
        for s1 in set1:
            for s2 in set2:
                if 24 in get_combination_2(s1, s2):
                    return "true"
    return "false"


print(get_combination_4([int(i) for i in input().split(" ")]))
