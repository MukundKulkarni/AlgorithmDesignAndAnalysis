import java.util.*;
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
        System.out.print("Enter Number of Elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        Random r = new Random();
        for(int i = 0; i<n; i++){
            arr[i] = r.nextInt(100);
        }
        System.out.print("\nEntered Array ====> ");
        InsertionSort ob = new InsertionSort();
        ob.sort(arr);
        ob.printArray(arr);
        System.out.println("\nFor best Case select middle element");
        int x = arr[n/2];
        double start = System.nanoTime();
        int result = binarySearch(arr,0,n-1, x);
        double end = System.nanoTime();
        System.out.println("\nFound Element at Position " + (result+1) + "   Time taken = " + (end-start)/100000 + "ms");
        System.out.println("\nFor Worst Case select Element outside array");
        x = 101;
        start = System.nanoTime();
        result = binarySearch(arr,0,n-1, x);
        end = System.nanoTime();
        System.out.println("\nElement Not Found  " + "   Time taken = " + (end-start)/100000 + "ms");
    }
}
