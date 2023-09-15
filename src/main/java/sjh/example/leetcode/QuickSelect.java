package sjh.example.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSelect {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    private static int quickSelect(List<Integer> nums, int k) {
        // 选出第k 大（*）
        // 随机选择基准数
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中: big | equal | small
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) {
                big.add(num);
            } else if (num < pivot) {
                small.add(num);
            } else {
                equal.add(num);
            }
        }
        // 第 k 大元素在 big 中，递归划分
        if (big.size() >= k) {
            return quickSelect(big, k);
        }
        // 第 k 大元素在 small 中，递归划分
        if (big.size() + equal.size() < k) {
            return quickSelect(small, k - big.size() - equal.size());
        }
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }

    public static int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }
}
