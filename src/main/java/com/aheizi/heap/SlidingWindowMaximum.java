package com.aheizi.heap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created by yangquan1 on 2019-08-18.
 *
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SlidingWindowMaximum {

    /**
     * 优先队列
     * <p>
     * 维护一个大顶堆，最大的元素在最上面，元素总数为堆的大小
     * 1. 加入一个元素
     * 2. 当堆的大小到K之后，remove 窗口最前面的元素：num[i + 1 - k]
     *
     * 暴力法的时间复杂度为 O(N*K)
     * 因为在最大堆中 heap[0] 永远是最大的元素。在大小为 k 的堆中插入一个元素消耗 \log(k)log(k) 时间，因此算法的时间复杂度为 {O}(N \log(k))O(Nlog(k))。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (k > nums.length || k == 0) {
            return nums;
        }

        int[] result = new int[nums.length + 1 - k];
        PriorityQueue<Integer> maxTopHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            maxTopHeap.add(nums[i]);
            if (maxTopHeap.size() == k) {
                result[j++] = maxTopHeap.peek();
                maxTopHeap.remove(nums[i + 1 - k]);
            }
        }
        return result;
    }

    /**
     * 双向队列的解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (k > nums.length || k == 0) {
            return nums;
        }

        int[] result = new int[nums.length + 1 - k];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);
            if (deque.peek() <= i - k) {
                deque.poll();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[8];
        nums[0] = 1;
        nums[1] = 3;
        nums[2] = -1;
        nums[3] = -3;
        nums[4] = 5;
        nums[5] = 3;
        nums[6] = 6;
        nums[7] = 7;

        int[] result = maxSlidingWindow2(nums, 3);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
