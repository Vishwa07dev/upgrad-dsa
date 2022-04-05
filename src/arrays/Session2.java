package arrays;

import java.util.Arrays;

public class Session2 {

    /**
     * Write the custom implementation of Dynamic array
     *
     * 1. Still have the power of arrays
     * 2. I should be able to change the size of the array dynamically
     */

    /**
     * Separate even and odd elements
     */

    public static void separate(int[] arr){

        int i=0 ;
        int j = arr.length-1;

        while(i<j){
            //till the time ith element is even, keep jumping right
            while(i<arr.length && arr[i]%2==0){
                i++;
            }

            //till the time jth element is off, keep jumping left
            while(j>=0 && arr[j]%2==1 ){
                j--;
            }

            if(i<j){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Find the row with maximum 1s
     */

    public static int findRowWithMaxOne(int[][]arr){

        int rows = arr.length;  // No of rows
        int columns = arr[0].length;  // No of clumns
        int j, maxRowIndex = 0;

        j= columns-1; //last column index

        for(int i=0;i<rows;i++){
            //Shift to the left till I keep finding 1
            while(j>=0 && arr[i][j]==1 ){
                j--;
                maxRowIndex=i;
            }
        }

        return maxRowIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        System.out.println(Arrays.toString(arr));
        separate(arr);
        System.out.println(Arrays.toString(arr));

    }

}

class DynamicArray {

    private int[] arr ;
    private int capacity ;
    private int count ; // count of elements stored in the array

    //Initialize the given array
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    //Inserting an element
    public void insert(int data){
        //check if the array is full
        if(isFull()){

            // I need to resize the array , we will make the size of the array twice
            capacity = capacity*2 ;
            int[] newArray = new int[capacity] ; // twice the previous capacity
            //Copy all the elements from the original array to new arr
            for(int i=0;i<this.arr.length;i++){
                newArray[i]=arr[i];
            }
            arr = newArray ;// original array should start pointing to the new array

        }
        arr[count++]= data;
    }

    private boolean isFull() {

        return count == capacity;
    }

    //Deleting an element
    public void delete(int index){
        //Check if the index is correct or not
        if(index <0 || index>=capacity){
            throw new RuntimeException("Index is not correct");
        }

        //To delete at index, we need to move all elements right of index, one position left
        int i = index ;
        while(i<count-1){
            arr[i]= arr[i+1];
            i++;
        }
        arr[count-1]=0;
        count-- ;
    }

    /**
     * Add an element at a given index in the array
     */
}
