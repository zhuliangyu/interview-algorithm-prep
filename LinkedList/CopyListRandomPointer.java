// https://leetcode-cn.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// 题型: 链表 + hash
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // key是旧链表上面的node, value是旧链表对应的新链表上面的node
        // oldNode1 -> oldNode2 -> oldNode3 -> ... 
        // newNode1 -> newNode2 -> newNode3 -> ...
        // key,  value  = oldNode1, newNode1
        // key,  value  = oldNode2, newNode2
        // key,  value  = oldNode3, newNode3
        HashMap<Node, Node> map = new HashMap<Node, Node>();

        Node dummy = new Node(0);
        Node pre = dummy; 
    
        // 为帮助理解, 设置curr来做走动指针
        Node curr = head;

        // 只申明, 但是没有指向, 在while循环里面根据复制再去指向
        Node newNode;


        // 原来的链表       curr -> ....
        // 新链表: pre ->  newNode
        // 因为新链表要修改, 所以移动的是pre指针, 而不是curr指针
        // 因为旧链表只是读取, 所以移动的是curr指针
        while (curr != null) {
            // 第一部分: 设置newNode
            // 写入hash的步骤都是先写入不包含的情况, 然后才是get这个hashtable
            if (!map.containsKey(curr)) {
                // 没见过, hashtable不包含的情况

                // 深拷贝
                newNode = new Node(curr.val);
                // 加入小本本
                map.put(curr, newNode);
                // 新链表 连上
                pre.next = newNode;

            } else {
                // 见过, 已经存在的
                
                // 从小本本是上取出来
                newNode = map.get(curr);
                
                // 连上
                // pre ->  newNode
                pre.next = newNode;
            }

            // 第二部分: 设置random指针
            if (curr.random != null) {
                if (!map.containsKey(curr.random)) {
                    // 小本本上没有
                    // 先创建, 再连上
                    newNode.random = new Node(curr.random.val);
                    // 在小本本上记录上
                    map.put(curr.random, newNode.random);

                } else {
                    // 小本本上有

                    // 把random指针连上
                    newNode.random = map.get(curr.random);
                }
            }

            // 旧链表和新链表都前进一格
            pre = newNode;
            curr = curr.next;
        }

        return dummy.next;
        
    }
}