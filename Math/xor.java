// https://leetcode-cn.com/problems/single-number/
// leetcode 136

// xor特性: 和减法相同的结果

// 与0抵消后还是自己本身
// X ⊕ 0 = X

// 可以与自身抵消性
// X ⊕ X = 0

class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}


// xor 不进位加法
