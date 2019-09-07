class Solution {
    int maxLen;
    int left;
    int right;
    public String longestPalindrome(String s) {
        String res = "";
        if (s == null || s.length() == 0) {
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            if (i != s.length() - 1) {
                helper(s, i, i + 1);
            }
        }
        return s.substring(left, right + 1);
    }
    
    public void helper(String s, int l, int r) {
        while(l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            } else {
                l--;
                r++;
            }
        }
        if (r - l - 1 > maxLen) {
            maxLen = r - l - 1;
            left = l + 1;
            right = r - 1;
        }
    }
}
