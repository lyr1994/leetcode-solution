class Solution:
    def generateAbbreviations(self, word: str) -> List[str]:
        res = []
        def helper(res, word, pos, cur, count):
            if pos == len(word):
                if count > 0:
                    cur = cur + str(count)
                res.append(cur)
                return
            helper(res, word, pos + 1, cur, count + 1)
            if count > 0:
                cur = cur + str(count) + word[pos]
            else:
                cur = cur + word[pos]
            helper(res, word, pos + 1, cur, 0)
        helper(res, word, 0, "", 0)
        return res
