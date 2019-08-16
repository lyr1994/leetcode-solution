class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int l = 0;
        int r = nums.length - 1;
        //find left most
        while (l + 1< r) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (nums[l] == target) {
            res[0] = l;
        }
        else if (nums[r] != target) {
            return res;
        } else {
            res[0] = r;
        }
        //find right most
        l = 0;
        r = nums.length - 1;
         while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid]) {
                r = mid;
            } else if (target >= nums[mid]) {
                l = mid;
            }
        }
        if (nums[r] == target) {
            res[1] = r;
        }
        else if (nums[l] != target) {
            return res;
        } else {
            res[1] = l;
        }
        return res;
    }
}
