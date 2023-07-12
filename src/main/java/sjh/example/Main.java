package sjh.example;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private final int count = 0;

    public static void main(String[] args) {


    }

    @Transactional
    public boolean insert() {
        System.out.println(1);
        int flag = 0;
        System.out.println(2);
        int res = 10 / flag;
        System.out.println(3);

        List<Boolean> visited = new ArrayList<>(10);
        for (int i = 0; i < visited.size(); ++i) {
            visited.set(i, true);
        }


        return true;
    }

    public void print() {
        System.out.println(count);
    }

    public void dfs(int[] nums, int target, int start, List<Integer> path, List<Boolean> visited) {
        for (int i = start; i < nums.length; ++i) {
            int num = nums[i];
            if (num > target) {
                return;
            } else if (num == target) {
                path.add(num);
            }
            // num < target
            visited.set(i, true);
            dfs(nums, target - num, i + 1, path, visited);
            visited.set(i, false);

        }
    }
}