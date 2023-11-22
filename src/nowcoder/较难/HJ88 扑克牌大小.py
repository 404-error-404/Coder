#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/20 18:20
# @Remarks  : 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
# 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
# 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
# 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
# 基本规则：
# （1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
# （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
# （3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
#
# （4）输入的两手牌不会出现相等的情况。
#
# 数据范围：字符串长度：3\le s\le 10\3≤s≤10
#
# https://www.nowcoder.com/practice/d290db02bacc4c40965ac31d16b1c3eb
s1, s2 = input().split("-")
JOKER = "JOKER"
joker = "joker"
ERROR = "ERROR"
val_map = {
    "3": 3,
    "4": 4,
    "5": 5,
    "6": 6,
    "7": 7,
    "8": 8,
    "9": 9,
    "10": 10,
    "J": 11,
    "Q": 12,
    "K": 13,
    "A": 14,
    "2": 15

}


def is_bomb(s: str):
    tmp = s.upper().split(" ")
    if tmp.count(JOKER) == 2:
        return True
    return tmp.count(tmp[0]) == 4


def compare():
    # 首先比较炸弹
    bomb1 = is_bomb(s1)
    bomb2 = is_bomb(s2)
    if bomb1:
        if bomb2:
            if s1[0] > s2[0]:
                return s1
            else:
                return s2
        else:
            return s1
    elif bomb2:
        return s2
    # 首先比较有王的情况
    if JOKER in s1:
        return s1
    elif JOKER in s2:
        return s2
    elif joker in s1:
        return s1
    elif joker in s2:
        return s2
    tmp1 = s1.split(" ")
    tmp2 = s2.split(" ")
    if len(tmp1) != len(tmp2):
        return ERROR
    if val_map[tmp1[0]] > val_map[tmp2[0]]:
        return s1
    else:
        return s2


print(compare())
