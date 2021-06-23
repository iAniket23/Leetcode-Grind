/*
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Example 4:

Input: x = -101
Output: false
*/

// My Solution
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        float mid = (float) (Math.log10(x) + 1);
        boolean ign = false;
        int n = (int) mid;
        if(n % 2 != 0){
            ign = true;
        }
        float counter = 0;
        mid = mid / 2;
        
        HashMap<Float, Integer> map = new HashMap<>();
        for (float i = 1; i <= mid; i++){
            int digit = x % 10;
            x = x/10;
    
            map.put(i, digit);
            counter = i;

        }
        if(ign){
            x = x/10;
        }
     
         for(float i = counter; i >=1; i--){
             if(map.get(i) == x%10){
                 x = x/10;
             }else{return false;}
         }
    
    return true;
    }
}

