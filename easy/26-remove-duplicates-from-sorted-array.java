class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}
