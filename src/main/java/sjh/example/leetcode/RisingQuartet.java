package sjh.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RisingQuartet {

    public static List<List<Integer>> findQuartets(int[] arr) {
        int n = arr.length;

        // 预计算左侧最小值
        int[] leftMin = new int[n];
        int min = arr[0];
        leftMin[0] = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= min) {
                min = arr[i];
                leftMin[i] = -1;
            } else {
                leftMin[i] = min;
            }
        }

        // 预计算右侧最大值
        int[] rightMax = new int[n];
        int max = arr[n - 1];
        rightMax[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                rightMax[i] = -1;
            } else {
                rightMax[i] = max;
            }
        }

        List<List<Integer>> quartets = new ArrayList<>();

        for (int j = 1; j < n - 2; j++) {
            for (int k = j + 1; k < n - 1; k++) {
                if (arr[k] > arr[j] && arr[j] > leftMin[j] && leftMin[j] != -1) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[l] > rightMax[k]) {
                            List<Integer> quartet = new ArrayList<>();
                            quartet.add(leftMin[j]);
                            quartet.add(arr[j]);
                            quartet.add(arr[k]);
                            quartet.add(arr[l]);
                            quartets.add(quartet);
                        }
                    }
                }
            }
        }

        return quartets;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<List<Integer>> result = findQuartets(arr);
        for (List<Integer> quartet : result) {
            System.out.println(quartet);
        }
    }
}
