// 双指针 + 翻转字符串
// 双指针, 一头一尾, 往中间去
// 类似题目: 判断回文
private static char[] ReverseString(char[] charArray, int left, int right) {
    while (left < right) { // 判断越界
        swap(charArray, left, right);
        
        left++;
        right--;
    }

    return charArray;
}

private static void swap(char[] A, int index1, int index2) {
    char tmp = A[index1];
    A[index1] = A[index2];
    A[index2] = tmp;
}