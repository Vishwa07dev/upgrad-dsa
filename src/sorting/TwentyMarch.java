package sorting;

import java.util.Arrays;

public class TwentyMarch {


    public static void bubbleRec(int[] arr , int size){

        if(size<=1){
            //no need to further sorting
            return;
        }

        //Logic
        for(int i=0;i<size-1;i++){
            if(arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1]=temp;
            }
        }

        //recursive
        bubbleRec(arr, size-1);
    }

    public static void sortO1(int[] arr){

        int i=0;
        int j= arr.length-1;//last index

        while(i<j){

            //Keep jumping to the right, till arr[i] is 0
            while(arr[i]==0){
                i++; //keep jumping right
            }
           while(arr[j]==1){
                j--;
            }
           if(i<j){
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
            }
        }
    }


    public static void sort123(int[] arr){
        int i0=0;
        int i1 =0;
        int i2= arr.length-1;

        while(i1<=i2){
           if(arr[i1]==1){
                i1++;
            }else if(arr[i1]==0){
                int temp = arr[i0];
                arr[i0]=arr[i1];
                arr[i1]=temp;
                i0++;
                i1++;
            }else{
                int temp = arr[i2];
                arr[i2]=arr[i1];
                arr[i1]=temp;
                i2--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        bubbleRec(arr, arr.length);

        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1,1,0,0,0,1,0,1,1};

        sortO1(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = { 2,1,0,1,2,1,0,0,0,0};

        sort123(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
