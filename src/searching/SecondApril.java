package searching;

public class SecondApril {

    public static void findFrequency(int[] arr){

        /**
         * Subtract 1 from each element
         */
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]-1;
        }

        /**
         * Transform the array
         */
        for(int i=0;i<arr.length;i++){
            arr[arr[i]%arr.length] =arr[arr[i]%arr.length] + arr.length;
        }

        /**
         * If I divide each element by arr.length, I will get the frequemcy
         */
        for(int i=0;i<arr.length;i++){
            System.out.println(i+1 +" -> "+ arr[i]/arr.length );
        }
    }

    public static int oddNumber( int[] arr){

        int num = arr[0];

        for(int i=1;i<arr.length;i++){
            num = num^arr[i];
        }

        return num;
    }


    public static int smallestIndex(int[] arr, int start, int end){
        if(start>end){
            return -1;
        }

        if(start==end){
            return start;
        }

        int mid = start + (end-start)/2 ;

        if(mid+1<=end && mid-1>= start && arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1]){
            return mid ;
        }

        if(arr[mid]>arr[start]){
            return smallestIndex(arr, mid+1, end);
        }else{
            return smallestIndex(arr, start, mid-1);
        }


    }

    public static void main(String[] args) {
        int[] arr = {2,3,3,2,5};

        System.out.println(oddNumber(arr));


    }


}
