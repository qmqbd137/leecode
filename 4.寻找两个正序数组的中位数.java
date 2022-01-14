import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 * //
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int total = l1 + l2;
        int k = total / 2;
        if(total % 2 ==1){
            return getkthElement(nums1,nums2,k+1);
        }
        else{
            return (getkthElement(nums1,nums2,k) + getkthElement(nums1,nums2,k+1))/2.0;
        }
    }
    public int getkthElement(int[] nums1,int[] nums2,int k){
        int length1= nums1.length, length2= nums2.length;
        int index1= 0,index2= 0;
        while(true){
            //处理边界越界情况
            if(index1 == length1){
                return nums2[index2+k-1];
            }
            if(index2 == length2){
                return nums1[index1+k-1];
            }
            if( k == 1 ){
                return Math.min(nums1[index1], nums2[index2]);
            }
            //正常循环
            int half = k/2;
            int newIndex1 = Math.min(index1+half,length1)-1;
            int newIndex2 = Math.min(index2+half,length2)-1;
            int prop1 = nums1[newIndex1];
            int prop2 = nums2[newIndex2];
            if(prop1 <= prop2){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1; 
            }else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1; 
            }
        }
    }
}
// @lc code=end

