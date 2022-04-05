package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Excercise {

    public static String[] convertToUpper(String[] arr) {
        if (arr.length - 1 < 0) {
            return arr;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i].toUpperCase();  // arr[i] _ mango -> MANGO
        }
        /**
         * { "abc", "def", "ghi"}
         * { "ABC" , "DEF", "GHI"}
         *
         */
        String[] arr2 = Arrays.copyOf(arr, arr.length - 1);
        return convertToUpper(arr2);
    }


    /**
     * { "abc", "def", "ghi"}   -> { "ABC" , "DEF", "GHI"}
     * @param args
     */

    public static void upperCase(String[] arr){

        upperCaseUtil(arr, 0);

    }

    private static void upperCaseUtil(String[] arr , int sI){
        if(sI>=arr.length){
            return;
        }
        arr[sI].toUpperCase();

        upperCaseUtil(arr, sI+1);
    }

    public static void main(String[] args) {

        String[] arr = {"mango", "apple", "lemon", "banana", "lichies", "PineApple"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many ele: ");
        int n = sc.nextInt();
        String[] arr2 = new String[n];

        for (int i = 0; i <= arr2.length - 1; i++) {
            System.out.println("Enter the elements to put on " + i + " : ");
            arr2[i] = sc.nextLine();
        }
        System.out.println(Arrays.toString(arr2));
        convertToUpper(arr);
        String[] res = convertToUpper(arr2);
        System.out.println(Arrays.toString(res));

    }
}
