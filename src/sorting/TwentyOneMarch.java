package sorting;

import java.util.Arrays;

public class TwentyOneMarch {


    /**
     * Logic for insertion sort
     *
     * Time complexity
     * Worst case : O(n*n)  [ 5,4,3,2,1]
     * Best case : [1,2,3,4,5]   O(n)
     *
     *
     * No of comparisons  :
     * Worst case : n*n
     * Best case : n
     *
     * No of swaps :
     *
     * Worst case : n*n
     * Best case : n
     *
     * Stable : Stable sorting algorithm
     *
     * Inplace : Yes or No < Yes, because no extra space is needed for this
     */
    public static void insertionSort(int[] arr){

        //Start with the 2nd element i.e index i=1
        for(int i=1;i<arr.length;i++){   // n times
            int v = arr[i];
            int j=i;// to keep track of elements from 0 to i

            // We need to ,move all the elements whose value is more than v one position right
            while(j-1>=0 && arr[j-1]>v){    //n times
                //shift one position right
                arr[j]= arr[j-1]; // j-1 element is now set to jth position
                j--;
            }
            arr[j]=v ;
        }

    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
