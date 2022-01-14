/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (66.73%)
 * Likes:    1965
 * Dislikes: 0
 * Total Accepted:    731.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 两个链表的节点数目范围是 [0, 50]
 * -100 
 * l1 和 l2 均按 非递减顺序 排列
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode res = resultNode;
        if(l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else{
            while(l1!=null && l2 != null){
                if(l1.val>l2.val){
                    resultNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                }else{
                    resultNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                resultNode = resultNode.next;
            }
            while(l1!=null){
                resultNode.next = new ListNode(l1.val);
                resultNode = resultNode.next;
                l1 = l1.next;
            }
            while(l2!=null){
                resultNode.next = new ListNode(l2.val);
                resultNode = resultNode.next;
                l2 = l2.next;
            }
            return res.next;
        }
    }
}
// @lc code=end

