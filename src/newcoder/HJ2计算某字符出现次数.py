#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/10/30 17:03
# @Remarks  :
# 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
#
# 数据范围： 1 \le n \le 1000 \1≤n≤1000
# 输入描述：
# 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
#
# 输出描述：
# 输出输入字符串中含有该字符的个数。（不区分大小写字母）

s = input()
c = input()
res = s.count(c)
if ord("z") >= ord(c) >= ord("a"):
    other_c = chr(ord(c) - ord("a") + ord("A"))
    res += s.count(other_c)
elif ord("Z") >= ord(c) >= ord("A"):
    other_c = chr(ord(c) - ord("A") + ord("a"))
    res += s.count(other_c)
print(res)
