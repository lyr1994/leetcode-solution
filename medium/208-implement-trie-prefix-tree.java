class Trie {

    /** Initialize your data structure here. */
    Trie[] children;
    boolean isLeaf;
    public Trie() {
        this.children = new Trie[26];
        this.isLeaf = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie[] cur = children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur[c - 'a'] == null) {
                Trie newTrie = new Trie();
                cur[c - 'a'] = newTrie;   
            }
            if (i == word.length() - 1) {
                cur[c - 'a'].isLeaf = true;
            }
            cur = cur[c - 'a'].children;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie[] cur = children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur[c - 'a'] == null) {
                return false;
            } else {
                if (i == word.length() - 1) {
                    return cur[c - 'a'].isLeaf;
                }
                cur = cur[c - 'a'].children;
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie[] cur = children;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur[c - 'a'] == null) {
                return false;
            } else {
                cur = cur[c - 'a'].children;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
