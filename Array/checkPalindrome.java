// 双指针 + 回文
private boolean checkPalindrome(char[] charArray, int left, int right) {
    while (left < right) {
        if (charArray[left] != charArray[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

// 双指针 + 翻转字符串
private static char[] ReverseString(char[] charArray, int left, int right) {
    while (left < right) {
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
