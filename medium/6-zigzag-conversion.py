class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if len(s) == 1 or numRows == 1:
            return s
        index, step = 0, 0
        L = [''] * numRows
        for c in s:
            L[index] += c
            if index == 0:
                step = 1
            elif index == numRows - 1:
                step = -1
            index += step
        return ''.join(L)
