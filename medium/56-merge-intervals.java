class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<int[]> res = new LinkedList<>();
        for (int cur = 0; cur < len; cur++) {
            int start = starts[cur];
            while (cur < len - 1 && starts[cur + 1] <= ends[cur]) {
                cur++;
            }
            int end = ends[cur];
            res.add(new int[]{start, end});
        }
        return res.toArray(new int[res.size()][2]);
    }
}
