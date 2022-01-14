


/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (42.95%)
 * Likes:    1606
 * Dislikes: 0
 * Total Accepted:    529.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1], n = 1
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中结点的数目为 sz
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
//问题： 1.如何在一次扫描之后返回头结点
        // 2.删除倒数第n个节点的操作
// 第二种解法：双指针，快慢指针法。满指针在快指针移动n次之后才开始移动
        class Solution {
            public ListNode removeNthFromEnd(ListNode head, int n) {
                //
                ListNode dummy = new ListNode(0, head);
                int length = getLength(head);
                ListNode cur = dummy;
                //倒数第n个节点 就是正数第length-n+1的节点
                for (int i = 1; i < length - n + 1; ++i) {
                    cur = cur.next;
                }
                //删除当前节点 
                cur.next = cur.next.next;
                ListNode ans = dummy.next;
                return ans;
            }
            public int getLength(ListNode head) {
                int length = 0;
                //下标计数值n与当前第n个节点相对应
                while (head != null) {
                    ++length;
                    head = head.next;
                }
                return length;
            }
        }
// @lc code=end

