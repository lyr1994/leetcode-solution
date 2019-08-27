class Solution {
    char[][] patterns = {{'(', ')'}, {')', '('}};
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        dfs(patterns[0], s, 0, 0, res);
        return res;
    }
    
    private void dfs(char[] pattern, String s, int start, int lastRemove, List<String> res) {
        int cnt = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == pattern[0]) cnt++;
            if (s.charAt(i) == pattern[1]) cnt--;
            if (cnt < 0) {
                for (int j = lastRemove; j <= i; j++) {
                    char c = s.charAt(j);
                    if (c == pattern[1] && (j == lastRemove || s.charAt(j - 1) != c)) {
                        dfs(pattern, s.substring(0, j) + s.substring(j + 1), i, j, res);
                    }
                }
                return;
            }
        }
        String newStr = new StringBuilder(s).reverse().toString();
        if (pattern == patterns[0]) {
            dfs(patterns[1], newStr, 0, 0, res);
        } else {
            res.add(newStr);
        }
    }
}
