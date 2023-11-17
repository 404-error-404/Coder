#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 16:15
# @Remarks  :
# s = input()
# next_idx = s.find(" ")

res = []
def print_param(s: str):
    if s == "":
        return
    if s[0] == " ":
        print_param(s[1:])
    if s[0] == '"':
        next_idx = s.find('"', 1)
        res.append(s[1:next_idx])
        print_param(s[next_idx + 2:])
    else:
        next_idx = s.find(" ")
        if next_idx == -1:
            res.append(s)
        else:
            res.append(s[:next_idx])
            print_param(s[next_idx + 1:])
print_param(input())
print(len(res))
print("\n".join(res))