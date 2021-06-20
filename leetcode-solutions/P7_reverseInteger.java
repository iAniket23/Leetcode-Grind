/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
*/

// My Solution
class Solution {
    public int reverse(int x) {
        boolean sign;
        long ans = 0;
        if(x < 0){
            sign = true;
        }else{sign = false;}
        long number = Math.abs((long)x);
        long counter = (long) (Math.log10(number));
        while(number / 10 != 0 || number % 10 != 0){
            
            ans = ans + (int) ((number%10)*(Math.pow(10,counter)));
            number = number/10;
            counter --;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            return 0;
        } else {
            if(sign){
            ans = 0 - ans;
        }else{}
            return (int)ans;
        }
        
        
        
    }
}

// Solution 2 - cleaner

class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
