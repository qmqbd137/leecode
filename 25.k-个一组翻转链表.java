/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (65.81%)
 * Likes:    1383
 * Dislikes: 0
 * Total Accepted:    250.6K
 * Total Submissions: 380.9K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 进阶：
 * 
 * 
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 列表中节点的数量在范围 sz 内
 * 1 
 * 0 
 * 1 
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode headTempNode =  new ListNode(0,head);
        ListNode temp = headTempNode;
        ListNode hair = head;
        while(hair!=null){
            ListNode tail = hair;
            for (int i = 1; i < k; i++) {
                tail = tail.next;
                if(tail == null){
                    return headTempNode.next;
                }
            }
            ListNode next = tail.next;
            //反转链表后，与原链表已经断开。因此在更新节点之前需要先将这段反转链表接到原链表中。
            //那该如何接入？已知反转头尾节点信息，这时头变尾 尾变头。
            reverseList(hair,tail.next);
            //tail为反转后头结点
            temp.next = tail;
            //temp移动k步到hair节点（此时已变为尾部）
            temp = hair;
            // 尾部需要连接剩余的链表（需提前保存节点信息）
            hair.next = next;
            // 更新hair节点到剩余链表的开头，
            hair = next;
        }
        return headTempNode.next;
    }
    //反转链表，保留头尾节点信息
    public void reverseList(ListNode start, ListNode end){
        ListNode pre = null;
        ListNode cur = start;
        while(cur!=end){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
// @lc code=end

