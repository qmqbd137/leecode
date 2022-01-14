/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (58.54%)
 * Likes:    1605
 * Dislikes: 0
 * Total Accepted:    746.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '121'
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 121
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：x = -101
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 
 * 
 * 
 * 
 * 
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        //回文数定义：将数反转之后仍然等于原数，但这里我们不得不考虑一个问题：反转之后数值越界问题因此取一半数字反转或者转换为long型
        //若是回文数则我们容易知道后一半数字的反转应该等于前一半，这里我们可以使用原数不断取10的模
        //通过公式 (res = res*10 + x%10)来将后半数不断反转，那么循环逻辑走通之后需要考虑循环停止条件
        //这里我们需要考虑整数长度为偶数的情况那么停止条件是 res == x（curval：循环进行时原数也会不断除10）
        //而长度为奇数时停止条件是 res> x 因为奇数位数多了一位 若算到x那边 循环不能进行 因为 res开始就比x小；因此算到res这边。
        //最终判断是否回文数也要考虑奇数时res会比x多一位 因此 通过res/10的办法去掉这一位再进行判断。
        int halfreserveval = 0;
        while(true){
            halfreserveval = halfreserveval * 10 + x % 10;
            x = x /10;
            if(halfreserveval >= x){
                break;
            }
        }
        if(halfreserveval == x || halfreserveval /10 == x){
            return true;
        }else{
            return false;
        }
    }
}
// @lc code=end

