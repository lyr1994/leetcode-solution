class Solution {
    public String minWindow(String s, String t) {
        int matchCount = 0;
        String res = "";
        if (s.length() == 0 || t.length() == 0) {
            return res;
        }
        int[] tArr = new int[256];
        int[] sArr = new int[256];
        for (int c : t.toCharArray()) {
            tArr[c]++;
        }
        int left = findNext(0, s, tArr);
        if (left == s.length()) {
            return res;
        }
        int right = left;
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (sArr[cur] < tArr[cur]) {
                matchCount++;
            }
            sArr[cur]++;
            while (matchCount == t.length()) {
                if (res.length() == 0 || res.length() > (right - left + 1)) {
                    res = s.substring(left, right + 1);   
                }
                char leftChar = s.charAt(left);
                if (sArr[leftChar] <= tArr[leftChar]) {
                    matchCount--;
                }
                sArr[leftChar]--;
                left = findNext(left + 1, s, tArr);
            }
            right = findNext(right + 1, s, tArr);
        }
        return res;
    }
    
    private int findNext(int start, String s, int[] tArr) {
        while (start < s.length() && tArr[s.charAt(start)] <= 0) {
            start++;
        }
        return start;
    }
}
