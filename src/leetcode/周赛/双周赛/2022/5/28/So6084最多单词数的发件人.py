#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/5/28 23:10
# @Remarks  :
# 给你一个聊天记录，共包含 n 条信息。给你两个字符串数组 messages 和 senders ，其中 messages[i] 是 senders[i] 发出的一条 信息 。
# 
# 一条 信息 是若干用单个空格连接的 单词 ，信息开头和结尾不会有多余空格。发件人的 单词计数 是这个发件人总共发出的 单词数 。注意，一个发件人可能会发出多于一条信息。
# 
# 请你返回发出单词数 最多 的发件人名字。如果有多个发件人发出最多单词数，请你返回 字典序 最大的名字。
# 
# 注意：
# 
# 字典序里，大写字母小于小写字母。
# "Alice" 和 "alice" 是不同的名字。
#  
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/sender-with-largest-word-count
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def largestWordCount(self, messages: List[str], senders: List[str]) -> str:
        max_person = senders[0]
        max_count = 0
        count = {}
        for i in range(len(messages)):
            p = senders[i]
            word_count = len(messages[i].split(" "))
            if p in count.keys():
                count[p] += word_count
            else:
                count[p] = word_count
            if count[p] > max_count:
                max_count = count[p]
                max_person = p
            elif count[p] == max_count:
                max_person = max(max_person, p)
        return max_person
