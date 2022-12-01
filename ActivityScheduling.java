
package algo;

import java.util.LinkedList;

public class ActivityScheduling {
    public static void quickSort(int[] s, int[] f, int low, int high) {
        if (low >= high)
            return;
        int p = partition(s, f, low, high);
        quickSort(s, f, low, p - 1);
        quickSort(s, f, p + 1, high);
    }

    private static int partition(int[] s, int[] f, int low, int high) {
        int pivot = f[high];
        int i = -1;
        for (int j = 0; j < high; j++) {
            if (f[j] < pivot) {
                i++;
                int t = f[j];
                f[j] = f[i];
                f[i] = t;
                t = s[j];
                s[j] = s[i];
                s[i] = t;
            }
        }
        i++;
        f[high] = f[i];
        f[i] = pivot;
        int t = s[high];
        s[high] = s[i];
        s[i] = t;
        return i;
    }

    public static int minProcessors(int[] start, int[] finish) {
        quickSort(start, finish, 0, finish.length - 1);

        LinkedList<Integer> processors = new LinkedList<>();
        for (int i = 0; i < finish.length; i++) {
            int proc = -1;
            for (int j = 0; j < processors.size(); j++) {
                if (processors.get(j) < start[i]) {
                    proc = j;
                    break;
                }
            }
            if (proc == -1) {
                processors.addLast(finish[i]);
            } else {
                processors.set(proc, finish[i]);
            }
        }
        return processors.size();
    }

    public static void main(String[] args) {
        int[] s = { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
        int[] f = { 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16 };
        System.out.println(minProcessors(s, f));

    }
}
