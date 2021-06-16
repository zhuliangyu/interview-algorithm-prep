// https://leetcode-cn.com/problems/merge-sorted-array/
// leetcode 88


// 合并两个有序的数组
// 考虑和Linkedlist merge的区别 Leetcode 21
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexNums1 = 0;
        int indexNums2 = 0;

        int indexTemp = 0;
        
        // 开辟一个新额外的数组, 耗费额外空间
        int[] temp = new int[m + n];

        // 必须这里是and的关系, 不考虑or的关系
        // 所以取最短的那个数组
        while (indexNums1 < m && indexNums2 < n) {
            if (nums1[indexNums1] < nums2[indexNums2]) {
                temp[indexTemp++] = nums1[indexNums1++];
            } else {
                temp[indexTemp++] = nums2[indexNums2++];
            }
        }

        // 以下分为两种情况: 
        // 1. nums1还没取完
        // 2. nums2还没取完
        while (indexNums1 < m) {
            // 难点: 先做赋值, 然后再做++
            // 这个写法要学习
            temp[indexTemp++] = nums1[indexNums1++];
        }

        while (indexNums2 < n) {
            temp[indexTemp++] = nums2[indexNums2++];
        }

        // 把排序后的数组元素倒腾会nums1, 因为最后测试是测的nums1
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = temp[i];
        }

    }
}




// 不推荐的版本!!!
public void merge(int[] nums1, int m, int[] nums2, int n) {
    // 两个指针, 分别指向两个数组
    int indexNums1 = 0, indexNums2 = 0;

    // 开辟一个新额外的数组, 耗费额外空间
    int[] sortedTemp = new int[m + n];

    int cur;

    while (indexNums1 < m  ||  indexNums2 < n) { // 考虑到 and 和 or 的区别
        // 先考虑两个特殊情况 
        if (indexNums1 == m) {
            // indexNums1到头了, 剩余全是p2 
            cur = nums2[indexNums2++];
        } else if (indexNums2 == n) {
            // p2到头了, 剩余全是indexNums1
            cur = nums1[indexNums1++];
        } 
        
        // 然后才是判断谁比较大
        if (nums1[indexNums1] < nums2[indexNums2]) {
            cur = nums1[indexNums1++];
        } else {
            cur = nums2[indexNums2++];
        }

        // 最后才是写入数组
        // 注意这里index 需要 - 1
        sortedTemp[indexNums1 + indexNums2 - 1] = cur;
    }

    // 把排序后的数组元素倒腾会nums1, 因为最后测试是测的nums1
    for (int i = 0; i != m + n; ++i) {
        nums1[i] = sortedTemp[i];
    }
}