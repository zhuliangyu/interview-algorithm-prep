class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        
        // 两个指针
        // 一个指针遍历source的string
        // 另外一个指针遍历target
        for (int sourceBeginIndex = 0; sourceBeginIndex < source.length() - target.length() + 1; sourceBeginIndex++) {
            int targetIndex = 0;

            // 对target从第一个开始判断
            for (targetIndex = 0; targetIndex < target.length(); targetIndex++) {
                // 原始字符串从i开始判断, target字符串从0开始
                if (source.charAt(sourceBeginIndex + targetIndex) != target.charAt(targetIndex)) {
                    // 只要发现一个不等于, 直接退出循环
                    break;
                }
            }
            // finished loop, target found
            if (targetIndex == target.length()) {
                return sourceBeginIndex;
            }
        }
        return -1;
    }
}

// Source
//    a    b   c   d   a   b   c   d    e    f   g
//    0    1   2   3   4   5   6   7    8    9   10
//    ^    ^   ^   
//         ^   ^  ^ (finish)

// target
//    b    c   d