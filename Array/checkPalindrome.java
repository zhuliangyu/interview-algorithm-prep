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


