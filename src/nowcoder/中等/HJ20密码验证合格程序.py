#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/9 16:13
# @Remarks  :
# 密码要求:
#
# 1.长度超过8位
#
# 2.包括大小写字母.数字.其它符号,以上四种至少三种
#
# 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
#
# 数据范围：输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
#
# https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841

import sys

legal = "OK"
illegal = "NG"


def is_legal_pwd(pwd: str) -> str:
    if len(pwd) <= 8:
        return illegal
    count_diff = {
        "big": 0,
        "small": 0,
        "num": 0,
        "other": 0
    }
    for s in pwd:
        if "0" <= s <= "9":
            count_diff["num"] = 1
        elif "a" <= s <= "z":
            count_diff["small"] = 1
        elif "A" <= s <= "Z":
            count_diff["big"] = 1
        else:
            count_diff["other"] = 1
    if sum(count_diff.values()) < 3:
        return illegal

    # 检查长度大于2的重复子串
    for i in range(len(pwd) - 3):
        if pwd.count(pwd[i:i + 3]) >= 2:
            return illegal
    return legal


for line in sys.stdin:
    print(is_legal_pwd(line.strip()))
