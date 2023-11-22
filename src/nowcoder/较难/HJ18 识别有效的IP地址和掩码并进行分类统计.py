#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/17 21:41
# @Remarks  : 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
#
# 所有的IP地址划分为 A,B,C,D,E五类
#
# A类地址从1.0.0.0到126.255.255.255;
#
# B类地址从128.0.0.0到191.255.255.255;
#
# C类地址从192.0.0.0到223.255.255.255;
#
# D类地址从224.0.0.0到239.255.255.255；
#
# E类地址从240.0.0.0到255.255.255.255
#
#
# 私网IP范围是：
#
# 从10.0.0.0到10.255.255.255
#
# 从172.16.0.0到172.31.255.255
#
# 从192.168.0.0到192.168.255.255
#
#
# 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
# （注意二进制下全是1或者全是0均为非法子网掩码）
#
# 注意：
# 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
# 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
#
# https://www.nowcoder.com/practice/de538edd6f7e4bc3a5689723a7435682
from typing import List

import sys


# for line in sys.stdin:
#     pass
def ip_to_binary(ip: str):
    res = ""
    for n in map(int, ip.split(".")):
        tmp = bin(n)[2:]
        res = res + "0" * (8 - len(tmp)) + tmp
    return res


ip_map = {
    "A": ["1.0.0.0", "126.255.255.255"],
    "B": ["128.0.0.0", "191.255.255.255"],
    "C": ["192.0.0.0", "223.255.255.255"],
    "D": ["224.0.0.0", "239.255.255.255"],
    "E": ["240.0.0.0", "255.255.255.255"]
}
private_ip = [
    ["10.0.0.0", "10.255.255.255"],
    ["172.16.0.0", "172.31.255.255"],
    ["192.168.0.0", "192.168.255.255"]
]
_res = {
    "A": 0,
    "B": 0,
    "C": 0,
    "D": 0,
    "E": 0,
    "error": 0,
    "private": 0
}


def is_valid_ip(ip: str):
    """
    :return: -1: 无效；1: 有效；0: 忽略
    """
    ip = ip.split(".")
    if len(ip) != 4:
        return -1
    for n in ip:
        try:
            tmp = int(n)
        except ValueError:
            return -1
        if not 0 <= tmp <= 255:
            return -1
    tmp = int(ip[0])
    if tmp == 0 or tmp == 127:
        return 0
    return 1


def is_valid_code(code: str):
    try:
        code_list = [int(c) for c in code.split(".")]
    except ValueError:
        return False
    if len(code_list) != 4:
        return False
    code = ip_to_binary(code)
    idx_0 = code.find("0")
    if idx_0 == -1 or idx_0 == 0:
        return False
    if code.find("1", idx_0) != -1:
        return False
    return True


def between(ip: str, ip_range: List[str]):
    ip_bin = ip_to_binary(ip)
    left = ip_to_binary(ip_range[0])
    right = ip_to_binary(ip_range[1])
    return left <= ip_bin <= right


for line in sys.stdin:
    _ip, _code = line.strip().split("~")
    _ip_valid = is_valid_ip(_ip)
    if _ip_valid != 1:
        _res["error"] -= _ip_valid
        continue
    if not is_valid_code(_code):
        _res["error"] += 1
        continue
    for k, v in ip_map.items():
        if between(_ip, v):
            _res[k] += 1
            break

    for r in private_ip:
        if between(_ip, r):
            _res["private"] += 1
            break
for v in _res.values():
    print(v, end=" ")