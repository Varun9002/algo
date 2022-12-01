package algo;

public class RotatedArray {
    public static int kRotated(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int a[] = { 29, 31,36, 41, 7, 18 };
        System.out.println(kRotated(a));
    }
}
