// https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
// leetcode 19

// 删除LinkedList第k个元素

// 快慢双指针
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        
        // 这里为什么是curr
        // 因为这里是做traverse, 所以是curr
        ListNode firstCurr = head;
        
        // 注意这里为什么是pre, 而不是curr        
        // 因为我们要CRUD这个元素, 我们要找的是pre而不是curr 
        ListNode secondPre = dummy;
        for (int i = 0; i < n; ++i) {
            firstCurr = firstCurr.next;
        }
        while (firstCurr != null) {
            firstCurr = firstCurr.next;
            secondPre = secondPre.next;
        }

        // 删除动作
        secondPre.next = secondPre.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
