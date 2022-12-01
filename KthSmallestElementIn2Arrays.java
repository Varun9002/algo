package algo;

public class KthSmallestElementIn2Arrays {
    private static String printA(int[] A,int low,int high){
        String s = " ";
        for (int i = low; i < high; i++) {
            s+= " "+A[i]+",";
        }
        return "["+s.substring(0, s.length() - 1) + " ]";
    }

    public static int kthElement(int[] A, int[] B, int low1, int low2, int high1, int high2, int k) {
        System.out.println(String.format("%-30s", printA(A, low1, high1)) +String.format("%-30s", printA(B, low2, high2)) + "\t"+k);
        if (low1 == high1) {
            return B[low2+k];
        }
        if (low2==high2) {
            return A[low1+k];
        }
        int mid1 = (low1 + high1) / 2;
        int mid2 = (low2 + high2) / 2;
        if ((mid1-low1)+ (mid2-low2)< k) {
            if (A[mid1] < B[mid2])
                return kthElement(A, B, mid1+1, low2, high1, high2, k - (mid1-low1) - 1 );
            else
                return kthElement(A, B, low1, mid2+1, high1, high2, k - ( mid2 - low2 ) - 1 );
        } else {
            if (A[mid1] < B[mid2])
                return kthElement(A, B, low1, low2, high1, mid2, k);
            else
                return kthElement(A, B, low1, low2, mid1, high2, k);
        }
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 3, 6, 7, 9, 12, 22 };
        int arr2[] = { 1, 4, 8, 10 };
        // for (int i = 0; i < 11; i++) {
        //     System.out.println(kthElement(arr1, arr2, 0, 0, arr1.length, arr2.length, i));
        // }
            System.out.println(kthElement(arr1, arr2, 0, 0, arr1.length, arr2.length, 3));

    }
}
