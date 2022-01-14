/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length<2){
            return s;
        }
        int maxlen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] schar = s.toCharArray();
        for (int L = 2; L <= length; L++) {
            for (int i = 0; i <= length; i++) {
                int j = i + L -1;
                if(j>=length){
                    break;
                }
                if(schar[i] != schar[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j-i+1>maxlen){
                    maxlen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxlen);
    }
}
// @lc code=end

