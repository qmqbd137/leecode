/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (37.27%)
 * Likes:    1445
 * Dislikes: 0
 * Total Accepted:    238.3K
 * Total Submissions: 639.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须 原地 修改，只允许使用额外常数空间。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：nums = [1]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length -2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = nums.length-1;
            while(j>=0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
            reverse(nums, i+1, nums.length-1);
        }else{
            reverse(nums, 0, nums.length-1);
        }
        System.out.println(nums.toString());
    }
    private void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums,int left, int right){
        while(left < right){
            swap(nums, left, right);
            left ++;
            right --;
        }
    }
}
// @lc code=end

