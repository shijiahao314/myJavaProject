package sjh.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RisingTriplet {

    public static List<List<Integer>> findTriplets(int[] arr) {
        // 枚举上升三元组，O(n**2) O(n)
        int n = arr.length;

        int[] prevMin = new int[n];
        int min = arr[0];
        prevMin[0] = -1; // 对于第一个元素，没有“之前”的元素
        for (int i = 1; i < n; i++) {
            if (arr[i] <= min) {
                min = arr[i];
                prevMin[i] = -1;
            } else {
                prevMin[i] = min;
            }
        }

        List<List<Integer>> triplets = new ArrayList<>();

        for (int j = 1; j < n - 1; j++) {
            if (prevMin[j] == -1 || arr[j] <= prevMin[j]) {
                continue;
            }
            for (int k = j + 1; k < n; k++) {
                if (arr[k] > arr[j]) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(prevMin[j]);
                    triplet.add(arr[j]);
                    triplet.add(arr[k]);
                    triplets.add(triplet);
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, 11, 10, 5, 6, 2, 30};
        List<List<Integer>> result = findTriplets(arr);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
