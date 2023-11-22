#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/20 15:52
# @Remarks  : Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
#
# 具体规则如下:
# 1.在英语读法中三位数字看成一整体，后面再加一个计数单位。从最右边往左数，三位一单位，例如12,345 等
# 2.每三位数后记得带上计数单位 分别是thousand, million, billion.
# 3.公式：百万以下千以上的数 X thousand X, 10亿以下百万以上的数：X million X thousand X, 10 亿以上的数：X billion X million X thousand X. 每个X分别代表三位数或两位数或一位数。
# 4.在英式英语中百位数和十位数之间要加and，美式英语中则会省略，我们这个题目采用加上and，百分位为零的话，这道题目我们省略and
#
# 下面再看几个数字例句：
# 22: twenty two
# 100:  one hundred
# 145:  one hundred and forty five
# 1,234:  one thousand two hundred and thirty four
# 8,088:  eight thousand (and) eighty eight (注:这个and可加可不加，这个题目我们选择不加)
# 486,669:  four hundred and eighty six thousand six hundred and sixty nine
# 1,652,510:  one million six hundred and fifty two thousand five hundred and ten
#
# 说明：
# 数字为正整数，不考虑小数，转化结果为英文小写；
# 保证输入的数据合法
# 关键字提示：and，billion，million，thousand，hundred。
#
# 数据范围：1 \le n \le 2000000 \1≤n≤2000000
#
# https://www.nowcoder.com/practice/1364723563ab43c99f3d38b5abef83bc
s = input()
eng_百 = "hundred"

eng_and = "and"
eng_1 = [
    "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
]
eng_2 = ["", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]


def three_to_eng(n: str):
    x, y, z = map(int, list(n))
    if x == y == z == 0:
        return None
    res = []
    if x != 0:
        res.append(eng_1[x])
        res.append(eng_百)
    if x != 0 and y + z != 0:
        res.append(eng_and)
    if y >= 2:
        res.append(eng_2[y])
    elif y == 1:
        res.append(eng_1[y * 10 + z])

    if y != 1 and z != 0:
        res.append(eng_1[z])
    return " ".join(res)


if len(s) % 3 != 0:
    s = "0" * (3 - len(s) % 3) + s
ans = []

for i in range(0, len(s), 3):
    ans.append(three_to_eng(s[i:i + 3]))
# 加千
tmp = len(ans)
if tmp >= 2 and ans[-2] is not None:
    ans.insert(-1, "thousand")
if tmp == 3:
    ans.insert(1, "million")


while None in ans:
    ans.remove(None)
print(" ".join(ans))
