class Solution {
    public void nextPermutation(int[] nums) {
        int last = nums.length - 1;
        while (last > 0 && nums[last - 1] >= nums[last]) {
            last--;
        }
        if (last == 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int idx = last - 1;
            while (last < nums.length && nums[last] > nums[idx]) {
                last++;
            }
            swap(nums, idx, last - 1);
            reverse(nums, idx + 1, nums.length - 1);
        }
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
