#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/12 12:45
# @Remarks  : 有6条配置命令，它们执行的结果分别是：
#
# 命   令	执   行
# reset	reset what
# reset board	board fault
# board add	where to add
# board delete	no board at all
# reboot backplane	impossible
# backplane abort	install first
# he he	unknown command
# 注意：he he不是命令。
#
# 为了简化输入，方便用户，以“最短唯一匹配原则”匹配（注：需从首字母开始进行匹配）：
#
# 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
# 2、若只输入一字串，但匹配命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
#
# 3、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果仍不唯一，匹配失败。
# 例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
# 例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
# 4、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果唯一，匹配成功。例如输入：bo a，确定是命令board add，匹配成功。
# 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：b addr，无法匹配到相应的命令，所以执行结果为：unknow command。
# 6、若匹配失败，打印“unknown command”
#
# 注意：有多组输入。
# 数据范围：数据组数：1\le t\le 800\1≤t≤800 ，字符串长度1\le s\le 20\1≤s≤20
# 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
#
# https://www.nowcoder.com/practice/ca6ac6ef9538419abf6f883f7d6f6ee5
from typing import List

import sys

def judge(s_: List[str], cmd_: List[str]):
    if len(s_) != len(cmd_):
        return False
    # 判断每个部分是否匹配
    for i in range(len(cmd_)):
        if not cmd_[i].startswith(s_[i]):
            return False
    return True



UNKNOWN = "unknown command"
cmd_list = [
    ["reset"],
    ["reset", "board"],
    ["board", "add"],
    ["board", "delete"],
    ["reboot", "backplane"],
    ["backplane", "abort"]
]
execute_list = [
    "reset what",
    "board fault",
    "where to add",
    "no board at all",
    "impossible",
    "install first"
]
for line in sys.stdin:
    s = line.strip().split(" ")
    res = []
    for idx in range(6):
        if judge(s, cmd_list[idx]):
            res.append(idx)
    if len(res) != 1:
        print(UNKNOWN)
    else:
        print(execute_list[res[0]])

