package searching;

public class AprilFourth {



    public static int findNumOccuring(int[] arr , int low , int high){
        if(low==high){
            return arr[low];
        }

        int mid = low + (high-low)/2 ;

        if(mid%2==1){
            if(arr[mid-1]==arr[mid]){
                return findNumOccuring(arr, low, mid-1);
            }else{
                return findNumOccuring(arr, mid+1, high);
            }
        }else{
            if(arr[mid+1]==arr[mid]){
                return findNumOccuring(arr, low, mid-1);
            }else{
                return findNumOccuring(arr, mid+1, high);
            }
        }
    }
}
