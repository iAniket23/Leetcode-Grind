/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104

*/

// My Soultion

class Solution {
    public int maxArea(int[] height) {
        int pointerStart = 0; 
        int pointerEnd = height.length - 1;
        int maxAreaq = 0;
        int tempArea = 0;
        int shorterSide;
        while(pointerEnd != pointerStart ){
            
            if(height[pointerEnd] <= height[pointerStart]){
                shorterSide = pointerEnd;    
            }else{shorterSide = pointerStart;}
            tempArea = (pointerEnd - pointerStart) * height[shorterSide];
            
            if(tempArea >= maxAreaq){
                maxAreaq = tempArea;}else{}
            
            if(height[pointerEnd] < height[pointerStart]){
                pointerEnd--;}
            else{pointerStart++;}
            
            
        
        }
        
        return maxAreaq;
    }
}

// Solution 2
public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}