class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = findLowerCloset(arr, x);
        int right = left + 1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(arr, left, right, x)) {
                res.add(arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }
        }
        Collections.sort(res);
        return res;
    }
    
    private boolean isLeftCloser(int[] arr, int l, int r, int target) {
        if (l < 0) {
            return false;
        }
        if (r >= arr.length) {
            return true;
        }
        if (arr[l] - target != target - arr[r]) {
            return target - arr[l] < arr[r] - target;
        }
        return true;
    }
    
    private int findLowerCloset(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (arr[r] < target) {
            return r;
        }
        if (arr[l] < target) {
            return l;
        }
        return -1;
    }
}
