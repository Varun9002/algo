package algo;

import java.util.Arrays;

public class SortDates {

    private static void countSort(String arr[], int exp) {
        int n = arr.length;
        String output[] = new String[n];
        int i;
        int count[] = new int[10];

        for (i = 0; i < n; i++)
            count[arr[i].charAt(exp) - 48]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[arr[i].charAt(exp) - 48] - 1] = arr[i];
            count[arr[i].charAt(exp) - 48]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    private static void radixsort(String arr[]) {
        int order[] = { 1, 0, 4, 3, 9, 8, 7, 6 };
        for (int ind : order) {
            countSort(arr, ind);
        }
    }

    public static void main(String[] args) {
        String dates[] = { "03-09-1999", "16-02-2000", "25-02-1998" };
        radixsort(dates);
        System.out.println(Arrays.toString(dates));
    }
}
