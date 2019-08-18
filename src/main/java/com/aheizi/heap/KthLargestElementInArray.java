package com.aheizi.heap;

import java.util.PriorityQueue;

/**
 * Created by yangquan1 on 2019-08-17.
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthLargestElementInArray {

    /**
     * 优先队列
     * <p>
     * 特性(仅做记录，题目无关)
     * leftNo = parentNo*2+1
     * rightNo = parentNo*2+2
     * parentNo = (nodeNo-1)/2
     * <p>
     * 使用小顶堆来实现,遍历插入优先队列，超过k，则重新调整小顶堆
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[6];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 1;
        nums[3] = 5;
        nums[4] = 6;
        nums[5] = 4;
        System.out.println(findKthLargest(nums, 2));
    }
}
