package sjh.example.designPattern.adapter;

import java.util.Arrays;

public class AdapterDemo {
    public static void main(String[] args) {
        byte[] res = new Adapter(new Speaker()).translate();
        System.out.println(res);
        System.out.println(Arrays.toString(res));
        System.out.println(new String(res));
    }
}
