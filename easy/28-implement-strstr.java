class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 < len2) {
            return -1;
        }
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == len2) {
                    return i;
                }
                if (i + j == len1) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }
}


// class Solution {
//     public int strStr(String haystack, String needle) {
//         return haystack.indexOf(needle);
//     }
// }
