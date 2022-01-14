/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
 * 心得： 此题的难点在于计算出数值之后如何在循环中将其组合成新的链表
 * 原因： 对基础链表的遍历，增加不熟悉，链表需加强联系
 * 解题思路： 
 *          1.考虑到两条链表的长度并不一致，因此循环的终止条件则是监测两条链表都为空时则停止；
 *          2.考虑当遍历完短链表时，值改如何相加；因此需要在取值时作处理：若链表为空，则取到的值为0；
 *          3.链表为数字逆序，正序遍历即可，需要设置进位符carry。相加值计算：sum：val1+val2+carry。值为sum mod 10，进位为 sum / 10
 *          4.循环结束还需判断是否有进位值，若有则需再加一位。
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode tail = null;
        ListNode head = null;
        while(l1 != null || l2 != null){
            //短链表需补零和长链表长度一致
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 +carry;
            //生产结果链表
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            //链表遍历
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        //循环完成仍有进位值则需再加一位
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
// @lc code=end

