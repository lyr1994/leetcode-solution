class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def isPalindrome(s):
            return s == s[::-1]
        self.cache = {}
        def helper(string):
            if string in self.cache:
                return self.cache[string]
            res = []
            for i in range(len(string)):
                if isPalindrome(string[:i+1]):
                    if i == len(string) - 1:
                        res.append([string[:i+1]])
                    else:
                        subs = helper(string[i+1:])
                        for sub in subs:
                            res.append([string[:i+1]] + sub)
            self.cache[string] = res
            return res
        return helper(s)
