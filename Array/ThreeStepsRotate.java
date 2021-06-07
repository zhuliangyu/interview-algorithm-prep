// inputStr = "abcdefg"
// offset = 3
// outputStr = "efgabcd"

0 1 2 3 4 5 6
a b c d e f g
        ^
offset = 3
length = 7

step1: reverse[0..3] = dcba efg
step2: reverse[4..6] = dcba gfe
step3: reverse[all] = efg abcd

public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0)
            return;
            
        offset = offset % str.length;
        
        // 翻转左边
        reverseString(str, 0, str.length - offset - 1);
        // 翻转右边
        reverseString(str, str.length - offset, str.length - 1);
        // 全部翻转
        reverseString(str, 0, str.length - 1);
}


private static char[] reverseString(char[] charArray, int left, int right) {
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