package algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class EqualWeigths {
    public static int[][] equalWeight(int A[], int W[], int c) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        int[][] ret = new int[A.length / 2][4]; // return [ A1 , A2 , W1 , W2 ]
        int counter = 0;
        for (int i = 0; i < W.length; i++) {
            LinkedList<Integer> x = map.get(c - W[i]);
            if (x != null && x.size() > 0) {
                int k = x.removeFirst();
                ret[counter][0] = A[i];
                ret[counter][1] = A[k];
                ret[counter][2] = W[i];
                ret[counter][3] = W[k];
                counter++;
            } else {
                LinkedList<Integer> t = new LinkedList<>();
                t.addFirst(i);
                map.putIfAbsent(W[i], t);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int a[] = { -1, -2, -3, -4, -5, -6, -7, -8 };
        int w[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        for (int[] i : equalWeight(a, w, 9)) {
            System.out.println(Arrays.toString(i));
        }
    }
}
