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