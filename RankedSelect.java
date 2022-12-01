package algo;

public class RankedSelect {
    
    public static int quickSelect(int arr[], int low, int high, int rank) {
        if(low>high)
            return Integer.MIN_VALUE;
        int p = partition(arr, low, high);
        if(rank<p+1)
            return quickSelect(arr, low, p-1, rank);
        else if(rank>p+1)
            return quickSelect(arr, p+1, high, rank);
        else    
            return arr[p];
    }

    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i=low-1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                int t = arr[j];
                arr[j] = arr[++i];
                arr[i] = t;
            }
        }
        arr[high] = arr[++i];
        arr[i] = pivot;
        return i;
    }
    public static void main(String[] args) {
        int a[] = { 36, 92, 96, 263, 81, 69, 24, 71, 84, 21 };
        System.out.println(quickSelect(a, 0, a.length - 1, 4));
    }
}