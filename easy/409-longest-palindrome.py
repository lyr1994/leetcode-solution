from collections import Counter
class Solution:
    def longestPalindrome(self, s: str) -> int:
        cnt = Counter(s)
        is_odd = False
        res = 0
        for n in cnt.values():
            is_even = False
            if (n % 2 == 0):
                is_even = True
            res += n if is_even else n - 1
            if not is_even:
                is_odd = True
        return res + 1 if is_odd else res
