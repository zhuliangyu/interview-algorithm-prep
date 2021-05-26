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
        ListNode pre = null;

        // pre     curr            
        // null     A       ->      B       ->     C        ->        Null


        while (curr != null) {
            // 需要有三个指针分别指向前\中\后 
            // 注意程序的特点是首尾相接, 和swap很类似的结构

            // pre     curr            next
            // null     A       ->      B       ->     C        ->        Null

            // 临时变量
            ListNode next = curr.next;

            // pre          curr         next
            // null     <-  A             B       ->     C        ->        Null
            curr.next = pre;

            //              pre          curr          next
            // null     <-  A             B       ->     C        ->        Null
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
