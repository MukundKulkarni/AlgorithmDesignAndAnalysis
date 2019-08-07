import java.util.*;
import java.text.*;
class BinarySearch {
    static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x){
                return mid;
            }
            if (arr[mid] > x){
                return binarySearch(arr, l, mid - 1, x);
            }
            else{
                return binarySearch(arr, mid + 1, r, x);
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        NumberFormat formatter = new DecimalFormat("#0.00000");

        System.out.print("Enter Number of Elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        Random r = new Random();
        for(int i = 0; i<n; i++){
            arr[i] = i+1;
        }
        System.out.print("\nEntered Array ====> ");
        InsertionSort ob = new InsertionSort();
        ob.printArray(arr);
        System.out.println("\nFor best Case select middle element");
        int x = arr[0];
        System.out.println("Searchin for " + x);
        double start1 = System.nanoTime();
        int result = binarySearch(arr,0,n-1, x);
        double end1 = System.nanoTime();
        System.out.println("\nFound Element at Position " + (result+1) + "   Time taken = " + (end1 - start1)/100000    + "ms");
        System.out.println("\nFor Worst Case select Element outside array");

    }
}
