import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.91%)
 * Likes:    900
 * Dislikes: 0
 * Total Accepted:    263.3K
 * Total Submissions: 573.6K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDifferentValue = Integer.MAX_VALUE;
        int resIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left<right){
                int differentValue = Math.abs(target - nums[left] - nums[right]- nums[i]);
                if(differentValue == 0){
                    resIndex = nums[i] + nums[left] + nums[right];
                    return resIndex;
                }
                if (differentValue < minDifferentValue){
                    minDifferentValue = differentValue;
                    resIndex = nums[i] + nums[left] + nums[right];
                }
                    if(target < nums[i] + nums[left] + nums[right]){
                        right--;
                    }else{
                        left++;
                    }
            }
        }
        return resIndex;
    }
}
// @lc code=end

