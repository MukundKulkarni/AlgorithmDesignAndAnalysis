import java.util.*;
class LinearSearch{
    public static int search(int arr[], int x){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == x)
                return i;
        }
        return -1;
}
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        Random r = new Random();
        for(int i = 0; i<n; i++){
            arr[i] = r.nextInt(100);
        }
        System.out.println("\nEntered Array");
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println("For best case");
        int x = arr[0];
        double start = System.nanoTime();
        int result = search(arr, x);
        double end = System.nanoTime();
        System.out.println("\n Time taken = " + (end-start)/100000 + "ms");
        System.out.println("For worst case");
        x = 101;
        start = System.nanoTime();
        result = search(arr, x);
        end = System.nanoTime();
        System.out.println("\n Time taken = " + (end-start)/100000 + "ms");
    }
}
