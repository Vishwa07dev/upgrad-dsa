package sorting;

import java.util.Arrays;

public class NineTeenthMarch {


    /**
     * Bubble sort ??
     */

    /**
     * Is it inplace ? InPlace algorithm  sc= constant O(1)
     * Time Complexity ? : O(n*n) | Best | worst | Average
     *
     *
     * Is it a stable sorting algorithm ? Yes, Stable
     *
     * Best : O(n)
     * Worst : O(n2)
     *
     * No of comparisons : n2
     *
     * No of swappings : n*n

     */
    public static void bubbleSort(int[] arr){
        for(int i=arr.length-1 ;i >=0;i--){  // n 1

            boolean isSorted = true;
            for(int j=0;j<i;j++){  //n
                if(arr[j]>arr[j+1]){
                    isSorted = false ;
                    //if left is more than right
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
           if(isSorted){ //not a single time it went inside the if block
                return; // it's already sorted !!!!!
            }
        }
    }

    /**
     *
     * InPlace ? inPlace
     * Stability ?  Unstable sorting
     *
     * TC :
     * Best : O(n*n)
     * Worst  : O(n*n)
     *
     * No of comparisons : n2
     *
     * No of swaps : n
     */
    public static void selectionSort(int[] arr){


        for(int i=0;i<arr.length;i++){ //n
            int min = i;
            for(int j=i+1;j<arr.length;j++){  //n
                if(arr[j]<arr[min]){
                    // I found a smaller element so update the min index
                    min= j;
                }
            }
            int temp = arr[i];
            arr[i]= arr[min];
            arr[min] = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};

        //bubbleSort(arr);
        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
