// https://www.jiuzhang.com/solution/sort-integers/

public class Solution {
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        // 耗费额外空间
        int[] temp = new int[A.length];
        
        mergeSort(A, 0, A.length - 1, temp);
    }
    
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        // 先把左边排好序
        mergeSort(A, start, (start + end) / 2, temp);
        // 先把右边排好序
        mergeSort(A, (start + end) / 2 + 1, end, temp);
        
        // 我是manager, 只做归并的事情
        merge(A, start, end, temp);
    }
    
    // 难点
    private void merge(int[] A, int start, int end, int[] temp) {
        // [1 ..... 1,  2......2]
        //  ^       ^   ^
        // left    mid  right
        int leftEnd = (start + end) / 2;
        int rightEnd = end;

        int leftStartIndex = start;
        int rightStartIndex = leftEnd + 1;
        
        int index = start;
        
        while (leftStartIndex <= leftEnd && rightStartIndex <= rightEnd) {
            if (A[leftStartIndex] <= A[rightStartIndex]) {
                temp[index++] = A[leftStartIndex++];
            } else {
                temp[index++] = A[rightStartIndex++];
            }
        }
        while (leftStartIndex <= leftEnd) {
            temp[index++] = A[leftStartIndex++];
        }
        while (rightStartIndex <= rightEnd) {
            temp[index++] = A[rightStartIndex++];
        }

        // 把 temp中的结果全部复制会A中, 因为A才是被返回结果
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }
}


// 分治方法
// 稳定性好, 但是耗费空间, 因为需要merge
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
    // 耗费额外空间 O(n)
    // 所以总体来说不如quicksort来的好
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
    int leftStartIndex = 0;
    int rightIndex = 0;

    // Copying from leftArray and rightArray back into array
    // 这里的关键点: 直接修改原来传进来的参数array, 这样在递归返回的时候, 就能把修改后的array也返回
    for (int i = low; i < high + 1; i++) {
        // If there are still uncopied elements in R and L, copy minimum of the two
        if (leftStartIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftStartIndex] < rightArray[rightIndex]) {
                // 直接修改原参数array
                array[i] = leftArray[leftStartIndex];
                leftStartIndex++;
            } else {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        } else if (leftStartIndex < leftArray.length) {
            // If all elements have been copied from rightArray, copy rest of leftArray
            array[i] = leftArray[leftStartIndex];
            leftStartIndex++;
        } else if (rightIndex < rightArray.length) {
            // If all elements have been copied from leftArray, copy rest of rightArray
            array[i] = rightArray[rightIndex];
            rightIndex++;
        }
    }
}