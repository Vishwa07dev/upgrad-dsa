package sorting;

import LL.DLLNode;

public class TwentySixthMarch {

    /**
     * Merge sort of the DLL
     */

    public static DLLNode  mergeSort(DLLNode head){

        //Base condition
        if(head==null || head.getNext()==null){
            return head ;
        }

        //Split this into two halves
        DLLNode head2 = split(head);

        //first half head = head1
        //second half head = head2

        DLLNode firstHalfSortedHead = mergeSort(head);

        DLLNode secondHalfSortedHead = mergeSort(head2);

        DLLNode sortedHead = merge(firstHalfSortedHead , secondHalfSortedHead);

        return sortedHead;

    }

    private static DLLNode merge(DLLNode firstHalfSortedHead, DLLNode secondHalfSortedHead) {


        if(firstHalfSortedHead==null){
            return secondHalfSortedHead;
        }
        if(secondHalfSortedHead==null){
            return firstHalfSortedHead;
        }

        if(firstHalfSortedHead.getData()<secondHalfSortedHead.getData()){
            firstHalfSortedHead.setNext(merge(firstHalfSortedHead.getNext(), secondHalfSortedHead));

            firstHalfSortedHead.getNext().setPrev(firstHalfSortedHead);
            firstHalfSortedHead.setPrev(null);
            return firstHalfSortedHead;
        }else{

            secondHalfSortedHead.setNext(merge(firstHalfSortedHead, secondHalfSortedHead.getNext()));

            secondHalfSortedHead.getNext().setPrev(secondHalfSortedHead);
            secondHalfSortedHead.setPrev(null);
            return secondHalfSortedHead;
        }



    }

    /**
     * break the given DLL form middle and return the head of the second part
     * @param head
     * @return
     */
    private static DLLNode split(DLLNode head) {

        DLLNode fast =head , slow = head ;

        while(fast !=null &&fast.getNext()!=null && fast.getNext().getNext()!=null){

            fast = fast.getNext().getNext();
            slow = slow.getNext();

        }

        //slow will be at the middle

        DLLNode head2 = slow.getNext();

        head2.setPrev(null);
        slow.setNext(null); // It will break the LL into two parts

        return head2 ;
    }


    /**
     * Merge the smaller array into the bigger array
     *
     * size of big -> m+n , with m elements
     * size of small -> n, with n elements
     */
    public static void merge(int[] big, int m , int[] small , int n){
         /**
         * index to track the final sorted elements in the big array
         */
        int i = m+n-1; // last index
        int bL = m-1;
        int sL = n-1 ;
        while(bL>=0 && sL>=0){
            if(big[bL]> small[sL]){
                big[i--]= big[bL--];
            }else{
                big[i--]=small[sL--];
            }
        }
        while(bL>=0){
            big[i--]=big[bL--];
        }

        while(sL>=0){
            big[i--]=small[sL--];
        }
    }

}
