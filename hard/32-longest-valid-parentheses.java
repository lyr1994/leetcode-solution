class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int leftmost = -1;
        int idx = 0;
        int max = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') {
                stack.push(idx++);
            } else if (s.charAt(idx) == ')') {
                if (stack.isEmpty()) {
                    leftmost = idx++;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(idx - leftmost, max);
                    }  else {
                        max = Math.max(idx - stack.peek(), max);
                    }
                    idx++;
                }
            }
        }
        return max;
    }
}
