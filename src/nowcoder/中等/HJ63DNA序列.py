#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 0:24
# @Remarks  : 一个 DNA 序列由 A/C/G/T 四个字母的排列组合组成。 G 和 C 的比例（定义为 GC-Ratio ）是序列中 G 和 C 两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的 GC-Ratio 可能是基因的起始点。
#
# 给定一个很长的 DNA 序列，以及限定的子串长度 N ，请帮助研究人员在给出的 DNA 序列中从左往右找出 GC-Ratio 最高且长度为 N 的第一个子串。
# DNA序列为 ACGT 的子串有: ACG , CG , CGT 等等，但是没有 AGT ， CT 等等
#
# 数据范围：字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ，输入的字符串只包含 A/C/G/T 字母
#
# https://www.nowcoder.com/practice/e8480ed7501640709354db1cc4ffd42a
s = input()
n = int(input())

tmp = s[:n]
start = 0
max_count = tmp.count("C") + tmp.count("G")
del tmp
cur_len = max_count
for idx in range(n, len(s)):
    if s[idx - n] == "C" or s[idx - n] == "G":
        cur_len -= 1
    if s[idx] == "C" or s[idx] == "G":
        cur_len += 1
    if cur_len > max_count:
        start = idx - n + 1
        max_count = cur_len
print(s[start: start + n])
