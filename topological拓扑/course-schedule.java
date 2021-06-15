// https://leetcode-cn.com/problems/course-schedule/
// leetcode 207


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        
        // Get the indegree and adjacency of every course.
        // 统计课程安排图中每个节点的入度，生成 入度表 indegrees
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        // Get all the courses with the indegree of 0.
        // 借助一个队列 queue，将所有入度为 0 的节点入队
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);
        
        // BFS TopSort.
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                // 减少入度
                if(--indegrees[cur] == 0) queue.add(cur);
        }

        return numCourses == 0;
    }
}
