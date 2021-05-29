package myLinkedList;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int value) {
        this.val = value;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

public class MyLinkedList {
    ListNode dummy;
    ListNode head;

    public MyLinkedList() {
        dummy = new ListNode(-1);
    }

    public int get(int location) {
        ListNode curr = dummy.next; // head

        // 这里是找某个数据, 而不是做修改
        // 所以移动的是curr指针
        for (int i = 0; i < location; i++) {
            curr = curr.next;
            // at the location at the right position
        }

        return cur.val;
    }

    public boolean contains(int value) {
        ListNode cur = dummy.next; // head

        // 移动curr指针
        while (cur != null) {
            if (cur.val == value) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void add(int location, int val) {
        // dummy points to the head
        // dummy.next = head
        ListNode pre = dummy;

        // 增删都会影响前一个指针
        // 所以, 移动的时候移动的是pre指针, 而不是curr指针
        for (int i = 0; i < location; i++) {
            // move pre pointer 
            pre = pre.next;
            // at the position before location
        }

        // pre是在要插入的之前
        ListNode newNode = new ListNode(val);

        // 多设置几个临时变量, 帮助程序做理解
        ListNode curr = newNode;
        ListNode next = pre.next;
        
        // 原来: pre --- next
        // 改变: pre --- curr --- next
        //              newNode

        // 其实可以不用这个, 因为只要return dummy.next就是head了
        if (location == 0) {
            this.head = newNode;
        }

        // newNode.next = pre.next;
        curr.next = next

        // pre.next = newNode;
        pre.next = curr

    }

    public void remove(int location) {
        ListNode pre = dummy;

        // 当你要做增删改查的时候移动pre指针, 千万不是移动curr指针
        // 增删都会影响前一个指针
        for (int i = 0; i < location; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;

        // delete curr, 以下这个是复杂的使用临时变量的方法
        // ListNode curr = pre.next
        // ListNode next = pre.next.next
        // pre.next = next

    }

    public void print() {
        ListNode cur = dummy.next;
        while (cur != null) {
            System.out.print((cur.val) + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print((cur.val) + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }

}
