import java.util.*;
class SelectionSort{
    int compare = 0;
    int swap = 0;

    void sort(int arr[])
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                compare++;
                if (arr[j] < arr[min_idx]){
                    min_idx = j;
                }
            }
            if(min_idx != i){
                swap++;
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    void revsort(int arr[])
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                if (arr[j] > arr[min_idx]){
                    compare++;
                    min_idx = j;
                }
            }
            if(min_idx != i){
                swap++;
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[]){
        SelectionSort ob = new  SelectionSort();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        Random r = new Random();
        for(int i = 0; i<n; i++){

            arr[i] = i+1;
        }
        ob.revsort(arr);
        System.out.println("\nTaking Reverse Sorted array for Best Case.\n");
        ob.printArray(arr);
        SelectionSort ob1 = new SelectionSort();
        double start = System.nanoTime();
        ob1.sort(arr);
        double end = System.nanoTime();
        System.out.print("\nSorted Array ===>");
        ob1.printArray(arr);
        System.out.println("\n Time taken for worst case = " + (end-start)/100000);
        System.out.println("\n Swaps = " + ob1.swap);
        System.out.println("\n Comparisons = " + ob1.compare + "\n");
        SelectionSort ob2 = new SelectionSort();
        System.out.println("\nTaking previously Sorted array for best Case.\n");
        //start = System.nanoTime();
        //ob2.sort(arr);
        //end = System.nanoTime();
        //System.out.print("\nSorted Array ===>");
        //ob.printArray(arr);
        //System.out.println("\n Time taken for best case = " + (end-start)/100000);
        //System.out.println("\n Swaps = " + ob2.swap);
        //System.out.println("\n Comparisons = " + ob2.compare + "\n");
    }
}
