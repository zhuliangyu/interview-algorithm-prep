// https://leetcode-cn.com/problems/merge-two-sorted-lists/

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      // 更加清晰, l1是head, 现在我们要做的是移动curr指针
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;


        // dummy套路四步走: 1. new dummy, 2. 设pre, 3. 设dummy.next, 4, return dummy.next
        ListNode dummy = new ListNode(0);
        // 套路: 把pre指向dummy
        // dummy是不能动的, 因为dummy.next指向头
        // 但是pre是可以动的, 不停的向后移动
        ListNode pre = dummy;
        // dummy.next现在还是未知的, 所以什么事情也不需要做
        
        // 11111-111
        // 22222
        while (l1Curr != null && l2Curr != null) {
            if (l1Curr.val < l2Curr.val) {
                // 对链表的修改, 一定是对pre的next的修改, 而不是对curr的修改
                pre.next = l1Curr;
                // 移动curr指针. 因为只是移动而已
                l1Curr = l1Curr.next;
            } else {
                pre.next = l2Curr;
                l2Curr = l2Curr.next;
            }

            // 移动pre指针
            pre = pre.next;
        }
        
        // 看哪个还没到结尾
        if (l1Curr != null) {
            // l1没结束--> l2肯定结束了
            pre.next = l1Curr;
        } else {
            // l1结束了, l2没结束
            pre.next = l2Curr;
        }
        
        return dummy.next;
    }
}