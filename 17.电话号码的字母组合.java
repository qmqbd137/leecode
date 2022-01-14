import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (57.29%)
 * Likes:    1543
 * Dislikes: 0
 * Total Accepted:    345.1K
 * Total Submissions: 602.2K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：digits = ""
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 
 * 
 */

// @lc code=start
class Solution {
    
    public List<String> letterCombinations(String digits) {
        //数字字母映射集
        Map<Character,String> phoneMap = new HashMap<>();
        //结果集
        List<String> resultList = new ArrayList<>();
        //
        StringBuffer track = new StringBuffer();
        if (digits.length() == 0) {
            return resultList;
        }
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        //深度优先遍历， 广度优先遍历
        targetNums(resultList, phoneMap, digits, 0, track);
        return resultList;
    }
    public void targetNums(List<String> combinations,Map<Character,String> phoneMap,String digits,Integer index,StringBuffer combination){
        //收集时间点
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                targetNums(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
// @lc code=end

