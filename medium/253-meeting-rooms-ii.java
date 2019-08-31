class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startIdx = 0;
        int endIdx = 0;
        int minRoom = 0;
        int curRoom = 0;
        while(startIdx < len && endIdx < len) {
            if (start[startIdx] < end[endIdx]) {
                curRoom++;
                minRoom = Math.max(curRoom, minRoom);
                startIdx++;
            } else {
                curRoom--;
                endIdx++;
            }
        }
        return minRoom;
    }
}
