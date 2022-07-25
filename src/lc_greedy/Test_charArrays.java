package lc_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_charArrays {
    public static void main(String[] args) {
        int[][] people= {{1,0},{2,1},{3,1},{4,1},{5,1},{6,1}};
        for (int i = 0; i < people.length; i++) {
            //System.out.println(Arrays.toString(people[i]));
        }
//        for (int[] p : people) {
//            System.out.println(p[1]);
//        }
        List<int[]> list = new ArrayList<>();
        for (int[] p:people) {
            list.add(p[1],p);
        }
        int[][] ints = list.toArray(new int[people.length][]);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }



    }
}
