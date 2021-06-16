考查三种题型: 
* quick sort
* merge sort
* quick select

Insertion sort O(N^2)
    * stability, 如果不改变, 位置不会变化 
    * small array, good solution
    * array is almost sorted, 这个很快, 只改变几个不对的位置

T(n) = 2T(n/2) + T(n)
merge sort:
    * 永远是nlogn
    * but use more space O(n)的空间复杂度
    * stable
    * lazy manager算法
        * 先做递归2T(n/2), 然后后做事情 T(n)
        * 先局部有序, 然后再merge让整体有序

quick sort 
    * 时间复杂度
        pivot不选第一个数字, 也不选最后一个数字
        如果你的pivot选择不是random, 最长情况会变成o(n^2), 而不是nlogn - 平均时间复杂度
        最差的情况: 当你的输入已经排好序了, 每次都选第一个数字, 变成n^2
    * 空间复杂度: O(1)
    * 不是stable的
    * 先做事情T(n), 然后去做递归2T(n/2)

distributed of inputs

深刻理解: do work upfront 和 do work later的两种方式: 

Divide and conquer T(n/2)算法
    * do work upfront
        quickSort: 每次选出一个pivot, 然后先做一些事情, 把比pivot小的数字放在左边, 大的放在右边; 然后左边接下去也这么做, 右边接下去也这么做...
        T(n) = T(n) /do work upfront/ + 2T(n/2) /左边接下去也这么做, 右边接下去也这么做..../

    * do work later 
        merge sort (stable): 假设你左边排序好了, 右边也排序好了, 这个时候你只要merge两个排好序的数组即可
        T(n) = 2T(n/2) /do work later/ + T(n) /merge两个排序好的数组/ 

Lazy Manager T(n-1) 算法
Decrease and Conquer
selection sort, bubble sort
    * do work upfront
        用o(n)选出一个最小的, 放到数组的前面, 然后用同样的方法做小弟t(n-1), 一样选出最小的放在数组前面....
        T(n) = O(n) + T(n-1)
        时间复杂度是O(n^2)

或者这么考虑 (insertion sort)
    * do work later 
        T(n) = T(n-1) + O(n)
        假设有一个人帮你把(n-1)个元素都排列好了, 现在你只需要用O(n)的时间复杂度, 把随后一个元素插入进排序好的n-1个元素即可

上面两种只是思考问题的不同方向, 区别只是O(n)这样的工作是先做还是后做的问题

先做排序后做双指针题型
T(n) = O(nlogn) /排序时间/ + O(n) /双指针时间/ 
