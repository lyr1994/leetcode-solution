class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def helper(left, right, curString, res):
            if left == 0 and right == 0:
                res.append(curString)
                return
            if left < right:
                helper(left, right - 1, curString + ")", res)
            if left > 0:
                helper(left - 1, right, curString + "(", res)
        
        res = []
        helper(n, n, "", res)
        return res
