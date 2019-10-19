class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(nums, res, new LinkedList<>());
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            res.add(new LinkedList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!permutation.contains(nums[i])) {
                permutation.add(nums[i]);
                dfs(nums, res, permutation);
                permutation.remove(permutation.size() - 1);
            }     
        }
    }
}
