import java.util.*;
class InsertionSort {
    int compare = 0;
    int swap = 0;
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            compare++;
            while (j >= 0 && arr[j] > key) {
                compare++;
                swap++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

    void revsort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[]){
        InsertionSort ob = new  InsertionSort();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        Random r = new Random();
        for(int i = 0; i<n; i++){

            arr[i] = i+1;
        }
        ob.revsort(arr);
        System.out.println("\nTaking Reverse Sorted array for Worst Case.\n");
        ob.printArray(arr);
        InsertionSort ob1 = new InsertionSort();
        double start = System.nanoTime();
        ob1.sort(arr);
        double end = System.nanoTime();
        System.out.print("\nSorted Array ===>");
        ob1.printArray(arr);
        System.out.println("\n Time taken for worst case = " + (end-start)/100000);
        System.out.println("\n Swaps = " + ob1.swap);
        System.out.println("\n Comparisons = " + ob1.compare + "\n");
        /*InsertionSort ob2 = new InsertionSort();
        System.out.println("\nTaking previously Sorted array for best Case.\n");
        start = System.nanoTime();
        ob2.sort(arr);
        end = System.nanoTime();
        System.out.print("\nSorted Array ===>");
        ob.printArray(arr);
        System.out.println("\n Time taken for best case = " + (end-start)/100000);
        System.out.println("\n Swaps = " + ob2.swap);
        System.out.println("\n Comparisons = " + ob2.compare + "\n");*/
    }
}
