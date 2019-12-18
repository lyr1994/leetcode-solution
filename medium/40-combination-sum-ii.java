class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(res, new LinkedList<>(), target, candidates, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> path, int target, int[] candidates, int cur) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (i > cur && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                return;
            }
            path.add(candidates[i]);
            dfs(res, path, target - candidates[i], candidates, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
