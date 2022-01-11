/*
January 10th 2022

You are given an integer array height of length n. There are n vertical lines drawn such that the 
two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container 
contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.

my solution works, however it could not reach the run time requirement, will post a
working solution below, using pointers, math.min and math.max
*/
class Solution {
    public int maxArea(int[] height) {
        int maxA = 0;
        
        for(int i = 0; i < height.length; i++) {
           
            outerloop:
            for(int j = height.length - 1; j > i; j--) {
                if(maxA != 0 && j != 1 && (height[i] * j - 1) < maxA / (j - 1))  {

                    break outerloop;
                }
                
                int temp = 0;
                if(height[j] <= height[i]) {
                    temp = height[j] * (j - i);
                    
                    if(temp > maxA) maxA = temp;
                    
                } else if(height[i] <= height[j]) {
                    temp = height[i] * (j - i);
                    
                    if(temp > maxA) maxA = temp;
                    
                }
                
            }
        }               
        return maxA;  
    }
}

/*
public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
	int maxArea = 0;

	while (left < right) {
		maxArea = Math.max(maxArea, Math.min(height[left], height[right])
				* (right - left));
		if (height[left] < height[right])
			left++;
		else
			right--;
	}

	return maxArea;
}
*/
