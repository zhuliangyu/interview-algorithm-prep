public static void mergeSort(int[] array, int low, int high) {
    // 当只有1个元素的时候, 退出递归
    if (high <= low) return;

    int mid = low + (high - low) / 2;
    // 左递归
    mergeSort(array, low, mid);
    // 右递归
    mergeSort(array, mid + 1, high);
    // 合并
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