class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }
        int preProd = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = preProd;
            preProd = nums[i] * preProd;
        }
        int postProd = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = postProd * res[i];
            postProd = nums[i] * postProd;
        }
        return res;
    }
}
