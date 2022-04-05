package searching;

public class ThirtyFirstMarch {

    // Iterative version
    // TC = O(n)
    public boolean isPresent(int [] arr , int num){

        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                return true ;
            }
        }
        return false ;
    }

    //Recursively
    //TC ? O(n)
    public boolean isPresentRec(int[] arr , int sI  , int num){

        //Base condition
        if(sI>=arr.length){
            return false ;
        }
        return arr[sI]==num || isPresentRec(arr, sI+1, num);

    }


    /**
        O(logn)
     */
    public static boolean binarySearch(int[] arr , int data){

        int left = 0;
        int right = arr.length-1;

        while(left<=right){

            int mid  = left + (right-left)/2 ;

            if(arr[mid] == data){
                return true ;
            }

            else if( arr[mid]> data){
                //data should lie in the left part of the array
                right = mid-1;
            }else{
                // data should be in the right part of the array
                left = mid+1;
            }
        }

        return false ;
    }

    /**
     * O(logn)
     * @param arr
     * @param sI
     * @param eI
     * @param num
     * @return
     */
    public boolean bsRec(int[] arr , int sI , int eI , int num){

          //Base / Termination
           if(sI > eI){
               return false ;
           }

           // Find the middle
        int mid = sI + (eI-sI)/2;

           if(arr[mid]==num){
               return true ;
           }

           else if(arr[mid]>num){
               // I should look in the left part of the array
               eI = mid-1;
           }else{
               sI = mid+1 ; // I should look in the right part of the array
           }

          return bsRec(arr, sI, eI, num);

    }



















}
