# https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/

# 滑动窗口通用模板
def findSubArray(nums):
    N = len(nums) # 数组/字符串长度
    
    left, right = 0, 0 # 双指针，表示当前遍历的区间[left, right]，闭区间
    
    # 保存当前结果
    sums = 0 # 用于统计 子数组/子区间 是否有效，根据题目可能会改成求和/计数
    
    res = 0 # 保存最大的满足题目要求的 子数组/子串 长度
    
    # 记住这里面有2个while循环
    # 第一重 while 循环是为了判断 right 指针的位置是否超出了数组边界
    while right < N: # 当右边的指针没有搜索到 数组/字符串 的结尾
        
        sums += nums[right] # 增加当前右边指针的数字/字符的求和/计数
        
        # 第二重 while 循环是让 left 指针向右移动到 [left, right] 区间符合题意的位置
        while 区间[left, right]不符合题意：# 此时需要一直移动左指针，直至找到一个符合题意的区间
        
            sums -= nums[left] # 移动左指针前需要从counter中减少left位置字符的求和/计数
        
            left += 1 # 真正的移动左指针，注意不能跟上面一行代码写反
        # 到 while 结束时，我们找到了一个符合题意要求的 子数组/子串
        
        res = max(res, right - left + 1) # 需要更新结果
        
        right += 1 # 移动右指针，去探索新的区间
        
    return res
