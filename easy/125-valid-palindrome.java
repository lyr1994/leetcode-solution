class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        char[] charArr = s.toCharArray();
        while (left < right) {
            while(left < right && (!Character.isLetterOrDigit(charArr[left]))) left++;
            while(left < right && (!Character.isLetterOrDigit(charArr[right]))) right--;
            if (charArr[left] != charArr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
