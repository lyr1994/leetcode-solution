class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;
        int res = 0;
        while (l <= r) {
            if (leftmax < rightmax) {
                res += Math.max(0, leftmax - height[l]);
                leftmax = Math.max(height[l], leftmax);
                l++;
            } else {
                res += Math.max(0, rightmax - height[r]);
                rightmax = Math.max(height[r], rightmax);
                r--;
            }
        }
        return res;
    }
}
