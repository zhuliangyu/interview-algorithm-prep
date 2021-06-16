# 一共就三种种题型
#     reverse
#         翻转字符串
#         判断回文串
    
#     two sum
#         两数之和
#         三数之和
        
#     partition
#         快速排序
#         颜色排序

def reverse(s):
    left, right = 0, len(s)-1
    while left < right:
        s[left], s[right] = s[right], s[left]
        left += 1
        right -= 1
        
# 两数之和
class Solution:
    def twoSum(self, numbers, target):
        numbers.sort()

        L, R = 0, len(numbers)-1
        while L < R:
            if numbers[L]+numbers[R] == target:
                return (numbers[L], numbers[R])
            if numbers[L]+numbers[R] < target:
                L += 1
            else:
                R -= 1
        return None