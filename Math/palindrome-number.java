// https://leetcode-cn.com/problems/palindrome-number/
// leetcode 9

//https://leetcode-cn.com/problems/palindrome-number/solution/hua-jie-suan-fa-9-hui-wen-shu-by-guanpengchn/

// 标签：数学
// 如果是负数则一定不是回文数，直接返回 false
// 如果是正数，则将其倒序数值计算出来，然后比较和原数值是否相等
// 如果是回文数则相等返回 true，如果不是则不相等 false
// 比如 123 的倒序 321，不相等；121 的倒序 121，相等


class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int cur = reverse(x);
        return cur == x;
    }

    // 利用之前背过的程序
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            //每次取末尾数字
            int tmp = x % 10;

            res = res*10 + tmp;

            // 每次都除以10
            x /= 10;
        }
        return res;
    }
}
