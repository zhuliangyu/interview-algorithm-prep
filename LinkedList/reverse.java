package myLinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list. add(0, 100);
        list. add(1, 101);
        list. add(2, 102);
        list. add(3, 103);
        list.print();

        ListNode newHead = reverse(list.head);

        list.print(newHead);

    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        
        // dummy node before head
        // reverse一个链表, 肯定会影响这个pre
        ListNode prev  = null;

        // pre     curr            
        // null     A       ->      B       ->     C        ->        Null


        while (curr != null) {
            // 需要有三个指针分别指向前\中\后 
            // 注意程序的特点是首尾相接, 和swap很类似的结构

            // prev     curr            next
            // null     A       ->      B       ->     C        ->        Null

            // 有curr, 有pre, 现在需要找到next
            // 三个指针都准备好了
            ListNode next = curr.next;

            // prev          curr         next
            // null     <-  A             B       ->     C        ->        Null
            curr.next = prev;

            //              pre          curr          next
            // null     <-  A             B       ->     C        ->        Null
            // 两个指针一起往后挪动
            // 记住前面的pre先挪动, 然后再移动curr; 顺序千万不能反了
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
