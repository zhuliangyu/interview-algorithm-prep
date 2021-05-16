
// 考虑分层问题的模板
queue.push(root);

level = 0;

while (queue 不空) {
    size = queue.size();

    // 在本层里面做事情
    // 这是第一个for, 循环限制在本层的数据
    for (int i = 0; i < size; i++) {

        cur = queue.pop();

        // 本层记录
        levelTempResult.add(cur);

        // 登记 cur已经访问过了
        cur.isVisited

        // 这是第二个for, 寻找本层下层的所有节点
        for (节点 in cur的所有相邻节点) {

            // 如果在图里面, 未被访问过这点很重要, 否则会进入死循环
            if (该节点有效 and 未被访问过) {
                queue.push(该节点);
            }
        }
        // 本层结束
    }

    // 可以做一些这层*结束后*可以做的事情, 比如sum, 或者做记录
    totalResult.add(levelTempResult);
    
    // 记录层数++
    level ++;
    
    // 下一个while循环进入下一层
}

// 作者：fuxuemingzhu
// 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/bfsmo-ban-yi-ci-bei-hui-chu-chu-shi-yong-by-fuxuem/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。