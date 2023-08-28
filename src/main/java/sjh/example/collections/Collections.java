package sjh.example.collections;

import java.util.*;

public class Collections {
    /**
     * @see java.util.Arrays
     * @see java.util.Collection
     * @see java.util.Set
     * @see java.util.List
     * @see java.util.Queue
     * @see java.util.Deque
     * @see java.util.Collection
     */

    public static void main(String[] args) {

        int[] array1 = new int[3];
        array1[0] = 1;
        array1[1] = 3;
        array1[2] = 2;
        // 1.Arrays.toString()
        System.out.println(Arrays.toString(array1));

        // 2.Arrays.sort() | Arrays.stream().sorted()
        Arrays.sort(array1);

        Arrays.fill(array1, 4);

        System.out.println(Arrays.toString(array1));

        int sum = Arrays.stream(array1).sum();
        System.out.println(sum);


        System.out.println(Arrays.toString(array1));

        int[] array2 = Arrays.copyOf(array1, 2);
        System.out.println(Arrays.toString(array2));
    }


}
