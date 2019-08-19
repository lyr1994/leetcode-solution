// class Solution {
//     public int[][] kClosest(int[][] points, int K) {
//         int[][] res = new int[K][2];
//         PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
//         for (int[] point : points) {
//             heap.add(point);
//         }
//         for (int i = 0; i < K; i++) {
//             res[i] = heap.poll();
//         }
//         return res;
//     }
// }

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int l = 0;
        int r = points.length - 1;
        int mid = 0;
        while (l < r) {
            mid = partition(points, l, r);
            if (mid == K) {
                break;
            } else if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int partition(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l < r) {
            while (l < r && !isLarger(pivot, points[r])) r--;
            points[l] = points[r];
            while (l < r && isLarger(pivot, points[l])) l++;
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }
    
    private boolean isLarger(int[] a, int[] b) {
        return a[0] * a[0] + a[1] * a[1] > b[0] * b[0] + b[1] * b[1];
    }
}
