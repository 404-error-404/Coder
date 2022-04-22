from typing import List


# 四数之和双指针方法在leetcode.双指针法.四数之和
def fourSum(nums: List[int], target: int) -> List[List[int]]:
    nums.sort()
    # 先遍历一遍，去除超过四个的多余的元素
    fast = 1
    slow = 0
    count = 1
    while fast < len(nums):
        if nums[fast] == nums[fast - 1]:
            count += 1
        else:
            count = 1
        if count <= 4:
            slow += 1
            nums[slow] = nums[fast]
        fast += 1
    nums = nums[:slow + 1]
    res = set()
    two_sum = {}
    three_sum = {}
    for i in range(len(nums)):
        diff = target - nums[i]
        if diff in three_sum.keys():
            for value in three_sum[diff]:
                temp_tuple = tuple([nums[value[0]], nums[value[1]], nums[value[2]], nums[i]])
                res.add(temp_tuple)
        # 更新三数之和
        for j in two_sum.keys():
            temp = nums[i] + j
            if temp in three_sum.keys():
                three_sum[temp].extend([[k[0], k[1], i] for k in two_sum[j]])
            else:
                three_sum[temp] = [[k[0], k[1], i] for k in two_sum[j]]
        # 更新两数之和
        for j in range(i):
            temp = nums[j] + nums[i]
            if temp in two_sum.keys():
                two_sum[temp].append([j, i])
            else:
                two_sum[temp] = [[j, i]]
    res = [list(temp_tuple) for temp_tuple in res]
    return res


nums1 = [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
         2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
         2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
# nums1 = [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -2, -3, -4, 5, 6, 4, 8, 9, 6]
target1 = 8
print(fourSum(nums1, target1))
