class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) {
            return Integer.MAX_VALUE;   
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int ret = 0;
        int x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++) {}
            ret += 1 << x;
            a -= b << x;
        }
        return (dividend > 0) == (divisor > 0) ? ret : -ret;
    }
}
