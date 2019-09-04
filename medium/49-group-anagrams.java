class Solution {
    int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    public int hashStr(String str) {
        int hash = 1;
        for (char c: str.toCharArray()) {
            hash *= primes[c - 'a'];
        }
        return hash;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<List<String>>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int hash = hashStr(str);
            List<String> list = map.get(hash);
            if (list == null) {
                list = new LinkedList<>();
                map.put(hash, list);
                res.add(list);
            }
            list.add(str);
        }
        return res;
    }
}
