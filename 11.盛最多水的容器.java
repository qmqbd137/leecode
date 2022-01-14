/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        if(height.length<2){
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = height.length-1;
        int maxArea = 0;
        while(leftIndex<rightIndex){
            if(height[leftIndex] <= height[rightIndex]){
                maxArea = Math.max(maxArea, height[leftIndex] * (rightIndex - leftIndex));
                leftIndex++;
            }else{
            maxArea = Math.max(maxArea, height[rightIndex] * (rightIndex - leftIndex));
            rightIndex--;
            }
        }
        return maxArea;
    }
}
// @lc code=end

