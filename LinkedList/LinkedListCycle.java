// https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/

// 链表 + Set
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 不用map, 用set
        Set<ListNode> seen = new HashSet<ListNode>();
        ListNode curr = head;

        // 走curr指针
        while (curr != null) {
            // 关键点: 如何判断是否能加进去
            if (!seen.add(curr)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}


// 第二种: 快慢指针解法
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        // 判断条件: 快慢指针是否相遇
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                // 链表结束了, 说明没环
                return false;
            }
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
        }
        // 有环的话, 快慢指针一定会相遇, 一定能退出while循环
        return true;
    }
}

// followup: 判断环的入口在哪里


// 变种题目: 问两个链表有没有交集? 
// 把l2头尾相连
// 从l1出发, 判断l1是否有环
// 题目的归化
