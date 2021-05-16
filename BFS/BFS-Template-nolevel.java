

// 不考虑分层问题的模板

queue.add (root)

while (queue 不空) {

    // 这个queue里面不停的加入可能不只是本层的数据, 可能有下面好几层的
    cur = queue.pop()
    
    for (节点 in cur的所有相邻节点){
        if (该节点有效 and 未访问过) {
            queue.push(该节点)
        }
    }

}
// 作者：fuxuemingzhu
// 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/bfsmo-ban-yi-ci-bei-hui-chu-chu-shi-yong-by-fuxuem/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。