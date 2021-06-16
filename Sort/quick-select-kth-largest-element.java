// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
// leetcode 215
// 相似题目: 找中位数, 找k变成找n/2的位置


// 不能直接排序, 因为花费nlogn
// quickselect的平均时间复杂度是 O(n)的
// T(n) = O(n) Partition + T(n/2) 二分法 = O(n)时间复杂度

// 方法1: 直接套用quickSort模板
// 其实这个方法不好写, 不如第二个方法来的直观
class Solution {
    public int findKthLargest(int[] nums, int k) {
         // write your code here
        if (nums== null || nums.length == 0) {
            return -1;
        }
        
        return quickSelect(nums, 0, nums.length - 1, k);

    }

    private int quickSelect(int[] A, int start, int end, int k) {
        if (start >= end) {
            return A[start];
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

            // 因为这里是从大到小第k个元素, 所以是 A[left] > pivot, 方向在这里不要弄错了
            while (left <= right && A[left] > pivot) {
                // left这个值比较大, 满足条件, 跳过这个index
                left++;
                // 对指针移位的时候, 每次都要检查是否越界
            }
            
            while (left <= right && A[right] < pivot) {
                // 跳过这个index, 因为这个比pivot小而且在右边
                //
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

        if (start + k - 1 <= right) {
            return quickSelect(A, start, right, k);
        }

        if (start + k - 1 >= left) {
            // 注意这里名次发生变化
            return quickSelect(A, left, end, k - (left - start));
        }

        // 刚好选到了!
        return A[right + 1];
    }
}






// 方法2: 使用quickSort的partition 模板
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 从小到大  --> 倒数第k大
        // 从小到大 --> 正数第len-k大
        // 转换一下，第 k 大元素的索引是 len - k
        // 题目转换为: 找到partition 后kth个数
        int target = len - k;

        // 以下是变化的地方
        // 这里不是用递归, 用的是while 死循环, 直到找到目的的kth
        while (true) {
            int index = partition(nums, left, right);
            
            //  二分法模板
            if (index == target) {
                // 找到了!!!!!
                return nums[index];
            } else if (target > index) {
                // 起始点, 从index + 1 开始
                left = index + 1;
            } else {
                // 无脑, 反一下
                right = index - 1;
            }
        }
    }

    // 背诵!!! 这个是通用模板
    public int partition(int[] nums, int left, int right) {
        // 选组数组的最后一个元素作为pivot
        int pivot = nums[right];
        
        // pIndex 是 partition Index
        int pIndex = left;

        // 不包含最后一个right元素, 因为已经做了pivot
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                // 找到小于 pivot 的元素, 全部交换到前面
                // 注意是什么和什么做交换
                swap(nums, pIndex, i);
                pIndex++;

            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, pIndex, right);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return pIndex;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

// 方法3: 使用已经实现好的PriorityQueue
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 思考: 为什么求最大值, 我们用的最小堆
        // 求前k大, 其实就是淘汰K + 1之后的小loser, 所以我们用最小堆, 而不是最大堆
        // java优先队列默认就是优先取到小的元素，即小顶堆, 最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b; // 小顶堆
            }
        });

        // 维护一个大小为k的最小堆，堆顶是这k个数里的最小的，遍历完数组后返回堆顶元素即可
        for(int num : nums){
            heap.offer(num);
            // heap只维持前k大即可
            if(heap.size() > k){
                // heap = k + 1
                // 只要把最小的那个元素删除就好了
                // 想想为什么!!!! 删除最后一个loser, 维持前k个牛人即可  
                heap.poll();
            }
        }

        // 取出k个元素中的最小值, 就是kth名次
        return heap.peek();
    }
}

