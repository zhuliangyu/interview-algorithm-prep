// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
// leetcode 215

// 方法1: 使用quickSort的partition 模板
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        // 题目转换为: 找到partition 后kth个数
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            
            // 以下是变化的地方
            // 这里不是用递归, 用的是while 死循环, 直到找到目的的kth
            if (index == target) {
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
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                // 找到小于 pivot 的元素, 全部交换到前面
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

// 方法2: 使用已经实现好的PriorityQueue
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

