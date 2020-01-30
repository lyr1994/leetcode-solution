class Solution {
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder prev;
        char say;
        int count;
        for (int i = 1; i < n; i++) {
            prev = cur;
            cur = new StringBuilder("");
            count = 1;
            say = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == prev.charAt(j - 1)) {
                    count++;
                    continue;
                } else {
                    cur.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }
            }
            cur.append(count).append(say);
        }
        return cur.toString();
    }
}
