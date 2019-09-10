class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i : seq) {
                indegree.putIfAbsent(i, 0);
                map.putIfAbsent(i, new HashSet<>());
            }
        }
        
        if (org.length != indegree.size()) {
            return false;
        }
        
        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) {
                continue;
            }
            for (int i = 0; i < seq.size() - 1; i++) {
                int e1 = seq.get(i);
                int e2 = seq.get(i + 1);
                if (map.get(e1).add(e2)) {
                    indegree.put(e2, indegree.get(e2) + 1);
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i : indegree.keySet()) {
            if (indegree.get(i) == 0) {
                queue.offer(i);
            }
        }
        
        int index = 0;
        while (queue.size() == 1) {
            int cur = queue.poll();
            if (index >= org.length || org[index] != cur) {
                return false;
            }
            for (int next : map.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
            index++;
        }
        return index == org.length;
    }
}
