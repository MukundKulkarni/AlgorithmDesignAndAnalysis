import java.util.*;
class BubbleSort
{
    int compare = 0;
    int swap = 0;
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            boolean swapped = false;
            for (int j = 0; j < n-i-1; j++)
            {
                compare++;
                if (arr[j] > arr[j+1])
                {
                    swap++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }

            }
            if(swapped == false){
                break;
            }

        }
    }

    void revsort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] < arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String args[]){
        BubbleSort ob = new  BubbleSort();
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
        BubbleSort ob1 = new BubbleSort();
        double start = System.nanoTime();
        ob1.sort(arr);
        double end = System.nanoTime();
        System.out.print("\nSorted Array ===>");
        ob1.printArray(arr);
        System.out.println("\n Time taken for worst case = " + (end-start)/100000);
        System.out.println("\n Swaps = " + ob1.swap);
        System.out.println("\n Comparisons = " + ob1.compare + "\n");
        /*BubbleSort ob2 = new BubbleSort();
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
