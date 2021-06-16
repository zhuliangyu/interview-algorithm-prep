// https://www.jiuzhang.com/solution/sort-integers/


public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {

        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        
        quickSort(A, 0, A.length - 1);
    }
    
    // 这个和mergeSort最大的差别在于
    // quickSort是先做这一层该做的事情, 然后再去下一层递归
    // mergeSort是lazy manager, 当你的手下把工作做完了, 你再返回去做你该合并做的事情
    // 区别是一个先做事, 一个是后做事情
    private void quickSort(int[] A, int start, int end) {
        if ( start >= end) {
            return;
        }
        
        int left = start, right = end;
        
        // 选中点, 选的不是index, 选的是value!!
        // 记住
        int pivot = A[(left + right) / 2];   
        
        // 为什么不是 left <  right
        // 因为我要让出循环的时候, 必须是right left错开的
        // 如果出循环的时候是==情况, 有一个边界的值, 一边在左边做排序, 一边在右边做排序, 最后会出现问题!!!
        // 不能让他们出现重叠的状况, 所以必须让左边右边的指针错开
        // 这里是在做partition!!!
        while (left <= right) {

            while (left <= right && A[left] < pivot) {
                // 找到下一个比pivot小的数字
                //  A[left] <= pivot 是错误的, 需要找的是比这个值小的, 才可以取做交换, == 的值不允许交换
                left++;
                // 对指针移位的时候, 每次都要检查是否越界
            }
            
            while (left <= right && A[right] > pivot) {
                // 找到下一个比pivot大的数字
                right--;
            }
            
            if (left <= right) { // 不越界
                // swap
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                
                // 各自往前走一步
                left++;
                right--;
            }
        }
        // partition 结束
        
        // 易错点: 出while循环之后
        // left位于右边
        // right 位于左边
        // [start...right...left...end]
        
        // 递归方法
        // 易错点这里, 是start 到right, 而不是到left
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
    
}



// 另外一个版本, 选择最右边成为partition
// 这个是partition单独函数的方法
class Solution {
    public List<Integer> sortArray(int[] nums) {
        if(nums.length <=0){
            return null;
        }
        quickSort(nums, 0,nums.length-1);
        
        List<Integer> res = new ArrayList<>();
        for(int i: nums){
            res.add(i);
        }
        
        return res;
    }
    
    public void quickSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        
        // pivot左边全是比pivot小的数字
        // pivot右边全是比ppivot大的数字
        int pIndex = partition(nums, start, end);
        
        // 所有pivot的左边
        quickSort(nums, start, pIndex-1);
        // 所有pivot的右边
        quickSort(nums,pIndex+1, end);
    }
    
    // 考查让你写一个partition
    public int partition(int[] nums, int start, int end){
        // 做法: 选择end作为pivot
        int pivot = nums[end];

        // 不要吝啬使用变量, 这样更容易理解
        // 这里如果直接用start很难理解
        int pIndex = start;
        

        // 这里有双指针, start指针和i指针
        // i是traverse指针, 快指针
        // pIndex是关键指针, 指向比pivot大的数字, 慢指针
        for(int i = start; i < end; i++){
            if(nums[i] < pivot){
                
                // 小的数和大的数做交换, 小的数字在前面, 大的在后面
                // 小于 pivot 的元素都被交换到前面
                //Swap(nums[i] and nums[pIndex]);
                int temp = nums[i];
                nums[i] = nums[pIndex];
                nums[pIndex] = temp;
                
                pIndex++;
            }
        }

        // 错误点: 如果用end作为pivot, 这里交换的就应该是end和pindex
        //Swap num[pIndex] and nums[end](end就是pivot number);
        int temp = nums[pIndex];
        nums[pIndex] = nums[end];
        nums[end] = temp;

        return pIndex;
    }

    private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
    }

}

