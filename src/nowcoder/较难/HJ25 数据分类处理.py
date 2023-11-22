#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/17 23:16
# @Remarks  : 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
#
# 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
#
# 数据范围：1 \le I,R \le 100 \1≤I,R≤100  ，输入的整数大小满足 0 \le val \le 2^{31}-1\0≤val≤2
# 31
#  −1
#
# https://www.nowcoder.com/practice/9a763ed59c7243bd8ab706b2da52b7fd
I = input().split(" ")[1:]
R = list(set(input().split(" ")[1:]))
R.sort(key=lambda a: int(a))
res = {}
for n in R:
    res[n] = []
    for idx in range(len(I)):
        if n in I[idx]:
            res[n].append(idx)
count = 0
for n in R:
    if len(res[n]) != 0:
        count += (len(res[n]) + 1) * 2
print(count, end=" ")
for n in R:
    if len(res[n]) == 0:
        continue
    print(n, len(res[n]), end=" ")
    for idx in res[n]:
        print(idx, I[idx], end=" ")
