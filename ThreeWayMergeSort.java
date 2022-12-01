package algo;

import java.util.Arrays;

public class ThreeWayMergeSort {
    static int c = 0;

    public static void mergeSort3way(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid1 = low + (high - low) / 3;
        int mid2 = low + 2 * (high - low) / 3;
        mergeSort3way(arr, low, mid1);
        mergeSort3way(arr, mid1 + 1, mid2);
        mergeSort3way(arr, mid2 + 1, high);
        merge(arr, low, mid1, mid2, high);
    }

    private static void merge(int[] arr, int low, int mid1, int mid2, int high) {
        int n1 = mid1 - low + 1, n2 = mid2 - mid1, n3 = high - mid2;
        int L[] = new int[n1 + 1];
        int M[] = new int[n2 + 1];
        int R[] = new int[n3 + 1];
        L[n1] = Integer.MAX_VALUE;
        M[n2] = Integer.MAX_VALUE;
        R[n3] = Integer.MAX_VALUE;
        for (int i = 0; i < n1; i++) {
            L[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            M[i] = arr[mid1 + i + 1];
        }
        for (int i = 0; i < n3; i++) {
            R[i] = arr[mid2 + i + 1];
        }
        int i = 0, j = 0, k = 0;
        for (int p = low; p <= high; p++) {
            if (L[i] <= M[j] && L[i] <= R[k])
                arr[p] = L[i++];
            else if (M[j] < L[i] && M[j] <= R[k])
                arr[p] = M[j++];
            else
                arr[p] = R[k++];
        }
    }

    public static void main(String[] args) {
        int a[] = { 36, 92, 96, 263, 81, 69, 24, 71, 84, 21 };
        mergeSort3way(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
