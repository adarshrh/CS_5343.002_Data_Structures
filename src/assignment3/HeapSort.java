package assignment3;

/**
 * Name: Adarsh Raghupati Hegde
 * NetId: axh190002
 */

public class HeapSort {

    public static void main(String args[])
    {
        int arr[] = {10, 20, 11, 1, 9, 14, 56, 19, 25, 42, 45, 82, 100, 200, 300};
        int n = arr.length;
        System.out.println("Input array is:");
        printHeap(arr);
        HeapSort hp = new HeapSort();
        arr = hp.heapify(arr);
        System.out.println("After heap construction:");
        printHeap(arr);
        arr = heapSort(arr);
        System.out.println("After heapsort:");
        printHeap(arr);
    }

    /**
     * Sorts the array in descending order using heap sort
     * @param arr
     * @return
     */
    private static int[] heapSort(int[] arr) {
        int n = arr.length;
        for (int i=n-1; i>0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyUtil(arr, i, 0);
        }
        return arr;
    }

    /**
     * Prints the heap
     * @param arr
     */
    private static void printHeap(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /**
     * Function to make an array into a Min heap
     * @param arr
     * @return
     */
    private int[] heapify(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyUtil(arr, n, i);
        return arr;
    }

    /**
     * Helper function to convert array to min heap
     * @param arr
     * @param n
     * @param i
     */
    private static void heapifyUtil(int[] arr, int n, int i){
        int smallest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] < arr[smallest])
            smallest = l;

        if (r < n && arr[r] < arr[smallest])
            smallest = r;

        if (smallest != i)
        {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            heapifyUtil(arr, n, smallest);
        }
    }

}
