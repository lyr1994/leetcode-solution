class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new LinkedList<>());
            }
            map.get(pair[1]).add(pair[0]);
        }
        
        int[] res = new int[numCourses];
        int first = 0;
        int last = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                res[last] = i;
                last++;
            }
        }
        while (first < last) {
            int cur = res[first];
            if (map.containsKey(cur)) {
                for (int i : map.get(cur)) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        res[last] = i;
                        last++;
                    }
                }
            }
            first++;
        }
        if (last == numCourses) {
            return res;
        }
        return new int[0];
    }
}
