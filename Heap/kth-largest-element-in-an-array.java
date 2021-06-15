// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
// leetcode 215


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

