

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
        
        int pIndex = partition(nums, start, end);
        
        // 所有pivot的左边
        quickSort(nums, start, pIndex-1);
        // 所有pivot的右边
        quickSort(nums,pIndex+1, end);
    }
    
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

