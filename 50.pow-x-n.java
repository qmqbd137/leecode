/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (37.69%)
 * Likes:    814
 * Dislikes: 0
 * Total Accepted:    238K
 * Total Submissions: 631.3K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -100.0 
 * -2^31 
 * -10^4 
 * 
 * 
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    //递归
    private double myPow(double x , long N){
        if(N == 0L){
            return 1.0;
        }
        double y = myPow(x, N/2);
        return N%2 == 0 ? y * y : y * y * x;
    }
    //迭代
    private double quickMul(double x , long N){
        double ans = 1.0;
        double x_contribute = x;
        while( N > 0L ){
            if(N % 2 == 1L){
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            N = N/2;
        }
        return ans;
    }
}
// @lc code=end

