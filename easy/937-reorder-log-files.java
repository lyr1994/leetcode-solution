class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> myCmp = new Comparator<String>(){
            public int compare(String s1, String s2) {
                int s1i = s1.indexOf(' ');
                int s2i = s2.indexOf(' ');
                char s1fc = s1.charAt(s1i + 1);
                char s2fc = s2.charAt(s2i + 1);
                
                if (s1fc <= '9') {
                    if (s2fc <= '9') {
                        return 0;
                    } else {
                        return 1;
                    }
                }
                if (s2fc <= '9') {
                    return -1;
                }
                int res = s1.substring(s1i + 1).compareTo(s2.substring(s2i + 1));
                if (res == 0) {
                    res = s1.substring(0, s1i).compareTo(s2.substring(0, s2i));
                }
                return res;
            }
        };
        Arrays.sort(logs, myCmp);
        return logs;
    }
}
