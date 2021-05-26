private static ListNode addNthFromBegin(ListNode head, int i, int val) {
    ListNode dummy = new ListNode(0, head);
    ListNode pre = dummy;

    //  pre                head
    // dummy        ->      A       ->      B       ->      C

    // linkedlist 加操作某一个元素, 一定要把curr放在这个操作的元素上, 并且预先设定好pre和next
    // 修改一个元素, 一定要操作这个元素之前的, 也要操作这个元素之后的那个值

    // 移动pre, 走到第n个点
    // 这里一定不能移动的是curr指针, 因为curr指针是无法寻找到pre的元素
    // 只能从pre元素找到curr和next的元素
    for (int j = 0; j < i; j++) {
        pre = pre.next;
    }


    // 关键步骤: 临时指针指向next
    //                                     pre             next
    // dummy        ->      A       ->      B       ->      C
    ListNode next = pre.next;

    
    // 前/中/后设置, curr, pre, next
    //                                     pre             curr            next  
    // dummy        ->      A       ->      B       ->      X       ->      C
    ListNode curr = new ListNode(val);

    // 指向变化
    curr.next = next;
    pre.next = curr;

    // 返回头指针
    return dummy.next;
}