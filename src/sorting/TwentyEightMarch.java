package sorting;

import java.util.Random;

public class TwentyEightMarch {


    /**
     * Need to find the pivot index and return
     */
    public static int pivotIndex(int[] arr, int s , int e){

        int pivot = arr[e];
        int i = s-1 ; //initialize the value of pivot index

        for(int j=s;j<e;j++){
            if(arr[j]<pivot){
                i++;
                swapElements(arr,i,j);
            }
        }
        //I need to move the pivot element to i+1 index
        swapElements(arr,i+1,e);
        return i+1;

    }

    private static void swapElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]=temp;
    }

    public static void quickSort(int[] arr , int s , int e){

        //Base condition
        if(s>=e){
            return;
        }
        int pI = pivotIndex(arr, s, e);
        //Every left of pI is smaller
        //Everything right of pI is larger
        quickSort(arr, s, pI-1);
        quickSort(arr, pI+1, e);

    }



    public static int pivotRandomIndex(int[] arr, int s , int e){

        //Adds randomness to the Quick sort algorithm
        Random random = new Random();
        int pivotRandom = random.nextInt(e-s)+s; // [s,e]
        int t = arr[e];
        arr[e]=arr[pivotRandom];
        arr[pivotRandom]=t;

        int pivot = arr[e];
        int i = s-1 ; //initialize the value of pivot index

        for(int j=s;j<e;j++){
            if(arr[j]<pivot){
                i++;
                swapElements(arr,i,j);
            }
        }
        //I need to move the pivot element to i+1 index
        swapElements(arr,i+1,e);
        return i+1;

    }

}
