快慢指针
类似于龟兔赛跑，两个链表上的指针从同一节点出发，其中一个指针前进速度是另一个指针的两倍。利用快慢指针可以用来解决某些算法问题，比如

计算链表的中点：快慢指针从头节点出发，每轮迭代中，快指针向前移动两个节点，慢指针向前移动一个节点，最终当快指针到达终点的时候，慢指针刚好在中间的节点。
判断链表是否有环：如果链表中存在环，则在链表上不断前进的指针会一直在环里绕圈子，且不能知道链表是否有环。使用快慢指针，当链表中存在环时，两个指针最终会在环中相遇。
判断链表中环的起点：当我们判断出链表中存在环，并且知道了两个指针相遇的节点，我们可以让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置。
求链表中环的长度：只要相遇后一个不动，另一个前进直到相遇算一下走了多少步就好了
求链表倒数第k个元素：先让其中一个指针向前走k步，接着两个指针以同样的速度一起向前进，直到前面的指针走到尽头了，则后面的指针即为倒数第k个元素。（严格来说应该叫先后指针而非快慢指针）