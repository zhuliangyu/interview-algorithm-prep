// 0000XXXXX的二分法题型
// leetcode 278
// https://leetcode-cn.com/problems/first-bad-version/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        if (n == 1) {
            if (isBadVersion(n)) {
                return n;
            }
            return -1;
        }
        
        int start = 1; 
        int end = n;

        // 相邻就退出, start == 1, end == 2 就退出
        // 出while循环之后, 这样会留下两个值, 去比较
        while (start + 1 < end) {
            // 防止溢出
            // int mid = (start + end) / 2;
            int mid = start + (end - start) / 2;
            
            if (isBadVersion(mid)) {
                // 找到, 但是题目中要找的是第一个
                end = mid;
            } else {
                // 取反一下
                // 把start换成end
                start = mid;
            } 
        }
        
        // 比两次
        // 找第一个错误, 所以从start开始找
        if (isBadVersion(start)) {
            return start;
        }
        if (isBadVersion(end)) {
            return end;
        }

        // 没找到
        return -1;
    }

}