package sorting;

import java.util.Arrays;

public class TwentyFourthMarch {

    /**


     mergeSort({5,4,3,2,1,0} , 0,5) -> { 0,1,2,3,4,5}
     mergeSort({5,4,3,2,1,0} , 1,4)  -> {5,1,2,3,4,0}
     mergeSort({5,4,3,2,1,0} , 0,3)  -> {2,3,4,5 ,1,0}
     */
    public static void mergeSort(int[] arr, int start, int end ){
        //Check the input
        if(start>=end){
            return ; // don't do anything
        }

        /**
         * I need to divide into two halves
         */
        //int mid = (start+end)/2 ;
        int mid = start + (end-start)/2 ;

        /**
         * Divide phase recusively
         */
        mergeSort(arr, start, mid); // sort the array [start,mid]

        mergeSort(arr, mid+1, end); // Sort the array [mid+1, end]

        /**
         * Conquer phase
         */
        merge(arr, start, mid, end);  // merge the two sorted Parts
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[ arr.length];
        int tIndex  = start ;//index to track the element in temp

        int leftS = start;
        int rightS = mid+1;

        while(leftS<=mid && rightS <=end){
            if(arr[leftS] <= arr[rightS]){
                temp[tIndex] = arr[leftS];
                tIndex++;
                leftS++;
            }else{
                temp[tIndex] = arr[rightS];
                tIndex++;
                rightS++;
            }
        }

        while(leftS<=mid){
            temp[tIndex++] = arr[leftS++];
        }
        while(rightS<=end){
            temp[tIndex++] = arr[rightS++];
        }
        for(int i=start;i<=end;i++){
            arr[i]=temp[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));


    }

}
