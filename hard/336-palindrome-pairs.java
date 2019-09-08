class Solution {
    private static class TrieNode {
        int index;
        List<Integer> list;
        TrieNode[] children;
        TrieNode() {
            index = -1;
            list = new LinkedList<>();
            children = new TrieNode[26];
        }
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            addWord(root, i, words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            search(root, res, i, words[i]);
        }
        return res;
    }
    
    private void addWord(TrieNode root, int index, String word) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (root.children[j] == null) {
                root.children[j] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }
            root = root.children[j];
        }
        root.list.add(index);
        root.index = index;
    }
    
    private void search(TrieNode root, List<List<Integer>> res, int index, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (root.index >= 0 && root.index != index && isPalindrome(word, i, word.length() - 1)) {
                res.add(Arrays.asList(index, root.index));
            }
            root = root.children[word.charAt(i) - 'a'];
            if (root == null) {
                return;
            }
        }
        
        for (int i : root.list) {
            if (i != index) {
                res.add(Arrays.asList(index, i));
            }
        }
        return;
    }
    
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
