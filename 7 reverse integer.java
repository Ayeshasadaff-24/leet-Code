class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            // 1. Pop the last digit off of x
            int pop = x % 10;
            x /= 10;
            
            // 2. Check for integer overflow BEFORE pushing the digit onto result
            // Max 32-bit int is  2147483647
            // Min 32-bit int is -2147483648
            
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; // Positive overflow
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0; // Negative overflow
            }
            
            // 3. Push the digit onto the result
            result = (result * 10) + pop;
        }
        
        return result;
    }
}
