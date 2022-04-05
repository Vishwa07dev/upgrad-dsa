package arrays;

public class Session1 {


    public static void findTwoNum(int[] arr , int sum){


        for(int i=0;i<arr.length;i++){
             int firstNum = arr[i];

             for(int j=i+1;j<arr.length;j++){
                 int secondNumber = arr[j];

                 if(firstNum + secondNumber ==sum){
                     System.out.println(firstNum +" : "+secondNumber);
                     return ;
                 }
             }
        }
        System.out.println("Two numbers whose sum is : " + sum +"doesn't exist");
    }


    public static void printReverse(int[] arr){
        for(int i=arr.length-1 ;i>=0;i--){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

    private static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +  "  ");
        }

        System.out.println();
    }

    public static void reverse(int[] arr){  // TC ?
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            //swap the elements at start and end index

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++ ;
            end--;
        }
    }

    /**
     * Code for printing a 2D array
     *  TC ?
     */
    public static void print2DArray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] +    "    ");
            }
        }
        System.out.println();
    }

    /**
     *
     * Spiral printing of the array
     */
    public void spiralPrint(int[][] arr){
        int sR = 0;
        int sC =0;
        int eR = arr.length-1;
        int eC = arr[0].length-1;
        int i =0 ;

        while(sR <= eR && sC <= eC){  // till this time keep printing elements

            for( i=sC ;i<=eC;i++){
                System.out.print(arr[sR][i] + "   ");
            }
            sR++;
            for(i=sR;i<=eR;i++){
                System.out.print(arr[i][eC] + "   ");
            }

            eC--;
            for(i=eC;i>=sC;i--){
                System.out.print(arr[eR][i]);
            }
            eR--;
            for(i=eR;i>=sR;i--){
                System.out.println(arr[i][sC]);
            }
            sC++;
           }

    }



    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}
        };

        print2DArray(arr);




        //int[] arr = { 3,6,1,3,9,4,2};  // Declared and Initialized both


        //int[] arr2 = new int[7];  // 1. Declaring

       /** //2. Initialize
        arr2[0]=3;
        arr2[1]=6;
        arr2[2]=1;
        arr2[3]=3;
        arr2[4]=9;
        arr2[5]=4;
        arr2[6]=2;

        //findTwoNum(arr, 15);

        **/
       /** int[] arr = { 3,6,1,3,9,4,2};

        System.out.println("Before");
        print(arr);
        reverse(arr);

        System.out.println("After");
        print(arr);**/

    }
}
