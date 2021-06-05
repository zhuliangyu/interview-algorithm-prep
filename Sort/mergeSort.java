// leetcode 88
// https://leetcode-cn.com/problems/merge-sorted-array/

// 合并两个有序的数组
// 考虑和Linkedlist merge的区别 Leetcode 21
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = 0, p2 = 0;
    int[] sorted = new int[m + n];
    int cur;

    while (p1 < m  ||  p2 < n) { // 考虑到 and 和 or 的区别
        // 先考虑两个特殊情况 
        if (p1 == m) {
            // p1到头了, 剩余全是p2 
            cur = nums2[p2++];
        } else if (p2 == n) {
            // p2到头了, 剩余全是p1
            cur = nums1[p1++];
        } 
        
        // 然后才是判断谁比较大
        if (nums1[p1] < nums2[p2]) {
            cur = nums1[p1++];
        } else {
            cur = nums2[p2++];
        }

        // 最后才是写入
        sorted[p1 + p2 - 1] = cur;
    }

    for (int i = 0; i != m + n; ++i) {
        nums1[i] = sorted[i];
    }
}


// 分治方法
public static void mergeSort(int[] array, int low, int high) {
    // 当只有1个元素的时候, 退出递归
    if (high <= low) return;

    int mid = low + (high - low) / 2;
    // 分治法

    // divide
    // 左递归
    mergeSort(array, low, mid);
    // 右递归
    mergeSort(array, mid + 1, high);
    
    // 合并 conquer
    merge(array, low, mid, high);
}

public static void merge(int[] array, int low, int mid, int high) {
    // Creating temporary subarrays
    int leftArray[] = new int[mid - low + 1];
    int rightArray[] = new int[high - mid];

    // Copying our subarrays into temporaries
    for (int i = 0; i < leftArray.length; i++)
        leftArray[i] = array[low + i];
    for (int i = 0; i < rightArray.length; i++)
        rightArray[i] = array[mid + i + 1];

    // Iterators containing current index of temp subarrays
    int leftIndex = 0;
    int rightIndex = 0;

    // Copying from leftArray and rightArray back into array
    // 这里的关键点: 直接修改原来传进来的参数array, 这样在递归返回的时候, 就能把修改后的array也返回
    for (int i = low; i < high + 1; i++) {
        // If there are still uncopied elements in R and L, copy minimum of the two
        if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                // 直接修改原参数array
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        } else if (leftIndex < leftArray.length) {
            // If all elements have been copied from rightArray, copy rest of leftArray
            array[i] = leftArray[leftIndex];
            leftIndex++;
        } else if (rightIndex < rightArray.length) {
            // If all elements have been copied from leftArray, copy rest of rightArray
            array[i] = rightArray[rightIndex];
            rightIndex++;
        }
    }
}