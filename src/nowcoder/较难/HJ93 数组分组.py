#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/20 18:53
# @Remarks  : 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），不是5的倍数也不是3的倍数能放在任意一组，可以将数组分为空数组，能满足以上条件，输出true；不满足时输出false。
#
# 数据范围：每个数组大小满足 1 \le n \le 50 \1≤n≤50  ，输入的数据大小满足 |val| \le 500 \∣val∣≤500
#
# https://www.nowcoder.com/practice/9af744a3517440508dbeb297020aca86
FALSE = "false"
TRUE = "true"
_ = int(input())
sum5 = 0
sum3 = 0
sum_other = 0
nums = []
for n in input().strip().split(" "):
    tmp = int(n)
    if tmp % 5 == 0:
        sum5 += tmp
    elif tmp % 3 == 0:
        sum3 += tmp
    else:
        sum_other += tmp
        nums.append(tmp)
sum_total = sum3 + sum5 + sum_other
if sum_total % 2 != 0:
    print(FALSE)
    exit(0)
target = sum_total // 2 - max(sum3, sum5)
if target == 0:
    print(TRUE)
    exit(0)
nums.sort()
count = set()
for n in nums:
    if n == target:
        print(TRUE)
        exit(0)
    tmp_count = count.copy()
    for t in tmp_count:
        next_num = t + n
        if next_num == target:
            print(TRUE)
            exit(0)
        else:
            count.add(next_num)
    count.add(n)
print(FALSE)
