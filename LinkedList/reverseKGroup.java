// leetcode 25

// 代码思维导图
// 主方法
//     setup dummy node
//     while 判断pre是否为空
//         执行自定义方法, 返回一个新pre

// 自定义方法
//     判断链表是否有k个数
//     翻转链表模板
//     首尾相连

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 所有的链表题目, 上来就给我设置好dummy.next, 最后直接return dummy.next, 这个是套路
        ListNode dummy = new ListNode(0);
        // dummy指针不能走, 是定海神针, 只能移动pre指针
        ListNode pre = dummy; // 这步骤的原因是, 能传入我自己的方法的必须是要翻转的前一个数, 这个非dummy莫属, 但是dummy我是不能修改, 所以修改head指针
        dummy.next = head;

        while (pre != null) {
            // 这个函数可以reverse从这个head开始的k个元素
            // 把下一个pre返还给我
            pre = reverseNextK(pre, k);
            // 如果head为空, 等于是已经完成了, 就不要继续. 
        }

        // 标准套路: 返回dummy.next就是头指针
        return dummy.next;

    }

    // pre -> n1 -> n2 -> n3 -> ...-> nk-1 -> nk  -> nk+1(不变)
    // pre -> nk -> nk-1 -> ...n3 -> n2 -> n1     -> nk+1(不变)
    // return n1 (as a pre for nk+1)
    private ListNode reverseNextK(ListNode pre, int k) {
        // 你要reverse k个点, 你需要修改k+1元素, 多包含的那个是pre
        // pre  ->    (n1   ->   n2  ->    n3  ->    n4   ->   n5)     ->      n6 
        // pre  ->    (n5   ->   n4  ->    n3  ->    n2   ->   n1)     ->      n6

        // 判断一下是否有k个点, 不够k个点, 直接return, 什么事情也不用做
        ListNode n1 = pre.next;

        // traverse 找到nk
        // 从pre开始移动, 移动k次
        // 而不是从curr开始移动!!!
        ListNode nk = pre;
        for(int i = 0; i < k; i++) {
            nk = nk.next;
            if (nk == null) {
                // 不够k个点
                return null;
            } 

        }

        // reverse linkedlist 模板
        // 翻转内部从n1到n5
        ListNode nkPlusOne = nk.next;
        ListNode newPrev = null; // 这个newPrev和前面的pre不是不同一个东西, 这个是杜撰的null尾
        ListNode curr = n1;
        
        // 错误 !!! 我第一次测试的时候, 写成了 curr != nk, 是错的!!
        while (curr != nkPlusOne) { // 这个原来是 curr != null修改过的
            ListNode next = curr.next;
            curr.next = newPrev;
            newPrev = curr;
            curr = next;
        }

        // 头尾连接起来
        // k = 5
        // pre  ->    (n5   ->   n4  ->    n3  ->    n2   ->   n1)     ->      n6
        pre.next = nk;
        n1.next = nkPlusOne;

        // 返回n6的pre指针
        return n1;

    }
}