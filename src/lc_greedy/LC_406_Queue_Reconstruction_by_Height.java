package lc_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 分析：
 * 1.先按照身高降序，k值升序进行排序：[[7，0],[7,1],[6,1],[5,0],[5,2],[4,4]]
 * 2.申请队列进行入队操作：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 */
public class LC_406_Queue_Reconstruction_by_Height {

    public static void main(String[] args) {
        int[][] people= {{5,0},{7,0},{5,2},{6,1},{4,4},{7, 1}};
        int[][] ints = reconstructQueue(people);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        //先按照身高降序，在按照k值升序
        //Arrays.sort(people,Comparator.comparingInt(value -> value[0]).reversed());
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            //p[1]是索引，重复的位置会往后推,这个add方法有个小问题，就是一定要有不一样的索引，假如索引都是1，那么将会报错
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
