package sorting;

import LL.ListNode;

public class TwentyTwoMarch {


    public static void waveForm(int [] arr){

        for (int i=1;i<arr.length;i=i+2){

            if(arr[i] < arr[i-1]){
                swap(arr,i, i-i);
            }
            if(i+1<=arr.length-1 && arr[i]<arr[i+1]){
                swap(arr, i, i+1);
            }
            //ith index is bigger than i-1 and i+1 th index elements
        }
    }


    /**
     * Insertion sort for the LinkedList
     */

    public static ListNode insertionSort(ListNode head){
        ListNode sortedHead = null ;
        ListNode current = head ;
        while(current!=null){//n times
            ListNode next  = current.getNext();
            //I need to insert current node at right position
            insertAtRightPosition(current, sortedHead); //n  // We need to define this method
            current = next;
        }
        head = sortedHead;
        return head;
    }
    private static void insertAtRightPosition(ListNode current, ListNode sortedHead) {
        if(sortedHead==null || sortedHead.getData()>=current.getData()){
            current.setNext(sortedHead);
            sortedHead= current;
        }else{
            //Start traversing from left/head till we find a node larger then the currentNode
            ListNode temp = sortedHead;
            while(temp.getNext()!=null && temp.getNext().getData()<current.getData()){
                temp=temp.getNext();
            }
            current.setNext(temp.getNext());
            temp.setNext(current);
        }

    }



    public static boolean canBeSortedBySwapping(int[] arr , int[] swap){

        //Bubble sort logic
        for(int i = arr.length-1;i>=0;i--){
            for(int j=0;j<i;j++){

                if(arr[j]>arr[j+1]){
                    //Swapping is needed

                    //Check if the swapping is allowed
                    if(swap[i]==1){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1]=temp;
                    }else{
                        return false;
                    }
                }
            }
        }

        return true ;
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
