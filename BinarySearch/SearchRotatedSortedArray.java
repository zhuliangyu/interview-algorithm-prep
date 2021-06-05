// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
// leetcode 33

public class Solution {
    public int searchRotatedSortedArray(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            }
            
            // 这里是一个最大的变化! 需要有一个上升状态的判断
            if (A[start] < A[mid]) {
                // start ... mid 之间是在单调上升的阶段
                if (A[start] <= target && target <= A[mid]) {
                    // target处于start ... mid 的单调上升区间
                    end = mid;
                } else {
                    // target不处于单调区间
                    // 反一下就好
                    start = mid;
                }
            } else {
                // mid...end是单调上升阶段
                if (A[mid] <= target && target <= A[end]) {
                    // target处于mid ... end 上升区间中
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}