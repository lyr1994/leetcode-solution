class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(candidates, 0, res, new LinkedList<>(), target);
        return res;
    }
    
    private void dfs(int[] candidates, int start, List<List<Integer>> res, List<Integer> combination, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(combination));
            return;
        }
        if (target < 0) {
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            dfs(candidates, i, res, combination, target - candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}
