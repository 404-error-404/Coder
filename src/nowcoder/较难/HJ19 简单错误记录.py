#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/17 22:34
# @Remarks  : 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
#
#
# 处理：
#
#
# 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是“相同”的错误记录。
# 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
# 3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
# 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
#
# 数据范围：错误记录数量满足 1 \le n \le 100 \1≤n≤100  ，每条记录长度满足 1 \le len \le 100 \1≤len≤100
#
# https://www.nowcoder.com/practice/2baa6aba39214d6ea91a2e03dff3fbeb
import sys


def simple_record(r: str) -> str:
    file_name, line_num = r.split(" ")
    file_name = file_name.split("\\")[-1]
    if len(file_name) > 16:
        file_name = file_name[-16:]
    return file_name + " " + line_num


count = {}
res = []

for line in sys.stdin.readlines():
    simple_line = simple_record(line.strip())
    if simple_line not in count.keys():
        if len(res) == 8:
            res.pop(0)
        res.append(simple_line)
    count[simple_line] = count.get(simple_line, 0) + 1
for l in res:
    print(l, count[l])
