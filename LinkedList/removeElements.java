// https://leetcode-cn.com/problems/remove-linked-list-elements/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // 套路
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        ListNode curr = pre.next;

        // 同向双指针, 一个指针指向pre,一个指向curr
        // 每次移动都要想到pre和curr的指针移动
        // 但是next指针是内部变量, 不用考虑
        while (curr != null) {
            // 套路: 临时变量指向next, 每次用完就释放
            // pre 和 curr才是最重要修改的
            ListNode next = curr.next;

            if (curr.val == val) {
                // 相等条件, remove
                // 跳过curr, 从pre直接连到next
                pre.next = next;
                // 当前的curr被删除了, 把curr设置成为next的位置!!! 这个地方之前写错了!!!
                curr = next;
                // 还有一个错误在这里: pre不要动!!!不要动!!!! 因为有可能有多个重复的元素可以删除
                // 比如1, 2, 3, 3, 3, 要删除3, pre指向2, 删除了第一个3之后, pre不动, 把curr移动到下一个, 继续删除
            } else {
                // 不相等!!!
                // move forward both pointers
                // 击鼓传花
                pre = curr;
                curr = next;
            }
        }

        return dummy.next;

    }
}