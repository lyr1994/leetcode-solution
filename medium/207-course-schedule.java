class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new LinkedList<>());
            }
            map.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map.containsKey(cur)) {
                for (int i : map.get(cur)) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        for (int i : indegree) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
