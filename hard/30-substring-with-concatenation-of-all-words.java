class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            return new LinkedList<Integer>();
        }
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();
        int num = words.length;
        int wordLen = words[0].length();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i <= len - num * wordLen; i++) {
            Map<String, Integer> tempMap = new HashMap<>(map);
            int j = 0;
            while (j < num) {
                String curStr = s.substring(i + j * wordLen, i + j * wordLen + wordLen);
                int remain = tempMap.getOrDefault(curStr, 0);
                if (remain <= 0) {
                    break;
                } else {
                    tempMap.put(curStr, tempMap.get(curStr) - 1);
                    j++;
                }
            }
            if (j == num) {
                res.add(i);
            }
        }
        return res;
    }
}
