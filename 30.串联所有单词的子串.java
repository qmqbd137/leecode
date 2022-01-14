import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> wordsIndex = new HashMap<>();

        List<Integer> resList = new ArrayList<>();
        int lengthOfword = 0;
        int lengthOfs = s.length();
        for(String word : words){
            lengthOfword += word.length();
            if(!wordsIndex.containsKey(word)){
                wordsIndex.put(word, 1);
            }else{
                wordsIndex.put(word, wordsIndex.get(word)+1);
            }
        }
        int oneWordLength = lengthOfword/words.length;
        for (int i = 0; i < lengthOfs-lengthOfword+1; i++) {
            String subString = s.substring(i, i+lengthOfword);
            boolean flag = true;
            HashMap<String,Integer> wordsIns = new HashMap<>();
            for (int j = 0; j < lengthOfword; j+=oneWordLength) {
                String wordiIns = subString.substring(j,j+oneWordLength);
                if(!wordsIndex.containsKey(wordiIns)){
                    flag = false;
                    break;
                }
                if(!wordsIns.containsKey(wordiIns)){
                    wordsIns.put(wordiIns, 1);
                }
                else{
                    wordsIns.put(wordiIns, wordsIns.get(wordiIns)+1);
                }
                if(wordsIns.get(wordiIns) > wordsIndex.get(wordiIns)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                resList.add(i);
            }
        }
        return resList;
    }
}
// @lc code=end

