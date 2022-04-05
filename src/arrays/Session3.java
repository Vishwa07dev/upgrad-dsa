package arrays;

import java.util.Arrays;

public class Session3 {


    /**
     * Permutation of all the elements of the array
     *
     * Heap's algorithm
     */

    public static void arrayPermutations(int[] arr , int size){
        //Base condition
        if(size==1){
            System.out.println(Arrays.toString(arr));
        }

        //Logic
        /**
         * I need to swap elements
         */
        for(int i=0;i<size;i++){
            // I NEED to consider each element for swapping

            //My fixed element is i, so I need to find the permutation of remoain

            arrayPermutations(arr, size-1);

            // I need to swap
            if(size%2==1){
                int temp = arr[0];
                arr[0]=arr[size-1];
                arr[size-1]=temp;
            }else{
                int temp = arr[i];
                arr[i]=arr[size-1];
                arr[size-1]=temp ;
            }


        }

    }







    /**
     * N Queen problem :
     * <p>
     * Given a board of size n*n : Place n queens on this n*n board,
     * such that no two Queens ever come in each other's path
     */

    public static boolean nQueenPositionPossible(int[][] board, int sCol) {
        if (sCol >= board[0].length) {
            //I am done placing queens at all the columns
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            // i, sCol -> I need to check if this position is correct

            if (isSafePosition(board, i, sCol)) {
                board[i][sCol] = 1;// this position is selected for Queen


                //Try recursively for the right columns

                if (nQueenPositionPossible(board, sCol + 1)) {
                    return true;
                }
                //undo the previous decided position
                board[i][sCol] = 0;

            }
        }

        return false;

    }

    private static boolean isSafePosition(int[][] board, int i, int sCol) {
        for (int j = 0; j < sCol; j++) {
            if (board[i][j] == 1) {
                return false; // it's not a safe position
            }
        }

        for (int row = 0, column = 0; row < i && column < sCol; row++, column++) {
            if (board[row][column] == 1) {
                return false;
            }
        }
        for (int row = board.length - 1, column = 0; row > i && column < sCol; row--, column++) {
            if (board[row][column] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        int[][] arr = new int[4][4];

        //print(arr);

        //System.out.println(nQueenPositionPossible(arr, 0));// True

       // print(arr); // Print the position of queens in the given array


        int[] arr1 = {1,2,3};
        arrayPermutations(arr1,arr1.length);

    }

    /**
     * Find the sum of all digits recursively
     */

    public static int sumOfDigits(int num) {

        // Base condition
        if (num < 0) {
            throw new RuntimeException("This is not a valid input number");
        }

        if (num <= 9) {
            return num;
        }

        // Logic
        int sum = sumOfDigitsUtil(num);
        //Recursive part
        return sumOfDigits(sum);
    }

    //Recursively the sum of digits
    private static int sumOfDigitsUtil(int num) {

        if (num == 0) {
            return num;
        }

        return (num % 10 + sumOfDigits(num / 10));
    }


}
