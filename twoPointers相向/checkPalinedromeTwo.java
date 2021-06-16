// https://leetcode-cn.com/problems/valid-palindrome-ii/
// leetcode 680

// 背诵贪心算法

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        
        if (left >= right) {
            return true;
        }
        
        // 关键点: 
        // 之前全是回文串
        // 接下来只有两种可能
        // 或者删除左边的 left + 1, right
        // 或者删除右边的 left, right - 1
        // 两个是or的关系, 只要任意一个是true, 整个就是true
        return isSubPalindrome(s, left + 1, right) || isSubPalindrome(s, left, right - 1);
    }
    
    private boolean isSubPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}