class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = (l + r) / 2;
        return Math.max(Math.max(helper(nums, l, mid), helper(nums, mid + 1, r)), crossSum(nums, l, r, mid));
    }
    
    private int crossSum(int[] nums, int l, int r, int mid) {
        if (l == r) {
            return nums[l];
        }
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = mid; i >= l; i--) {
            curSum += nums[i];
            leftSum = Math.max(curSum, leftSum);
        }
        curSum = 0;
        for (int i = mid + 1; i <= r; i++) {
            curSum += nums[i];
            rightSum = Math.max(curSum, rightSum);
        }
        return leftSum + rightSum;
    }
}
