// https://leetcode-cn.com/problems/valid-palindrome/
// leetcode 125

// 双指针 + 回文

// 两个指针, 一头一尾往中间去的情况
// 类似题目: 翻转字符串
private boolean checkPalindrome(char[] charArray, int left, int right) {
    while (left < right) { // 不越界
        if (charArray[left] != charArray[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

public class Solution {
    public boolean isPalindrome(String s) {
        // 空判断
        if (s == null || s.length() == 0) {
            return true;
        }

        // 特殊情况判断, 只有1个元素, 无法在双指针的情况下
        if (1 == s.length()) { // for empty string “.,,,”     
            return true; 
        }  

        int front = 0;
        int end = s.length() - 1;

        // 错误点: 这里不需要把String 转化为 charArray, 这样耗费额外的空间
        // 错误点: 如果只有一个元素, 根本没有两个元素让你做判断, 我忽视了这个问题
        // 当你做双指针的题目的时候, 最少保证要有2根指针都有所指才可以
        while (front < end) {
            // 错误点: 没有注意审题
            // 错误点: 每次++时候要判断front是否越界
            // 经验超过2个and or必须要包装到一个函数里面
            while (front < end && !isValid(s.charAt(front))) { // nead to check range of a/b
                front++;
            }

            while (front < end && ! isValid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                // break;
                // 这里可以直接return false
                return false;
            } else {
                front++;
                end--;
            }
        }

        // 跳出while 循环, 这个时候 front == end
        // 这里可以直接return true
        // return end <= front; 
        return true;
    }

    private boolean isValid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}


