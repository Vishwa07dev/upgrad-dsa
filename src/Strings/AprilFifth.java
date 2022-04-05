package Strings;

import java.util.Arrays;

public class AprilFifth {

    /**
     * Commons methods of string
     */

    public static void main(String[] args) {

        // Length
        System.out.println("Vishwa".length());

        /**
         * Replace a character with something else
         */
        System.out.println("VishVa".replace("V", "M"));

        /**
         * Concatenation
         */
        System.out.println("Vishwa" + "Mohan");
        System.out.println("Vishwa".concat("Mohan"));

        /**
         * How to know the index of a character in String
         *
         * String - array of characters | index also starts from 0
         */

        System.out.println("Vishwa Mohan".indexOf('M'));

        /**
         * Find the character at a given index
         */

        System.out.println("Vishwa Mohan".charAt(3));

        /**
         * Comparing two strings
         *
         * compareTo -> Positve num | Zero | Negative
         */
        System.out.println("Vishwa".compareTo("Mohan"));

        /**
         *  "Vishwa" -- if "shw" is present ?
         */
        System.out.println("Vishwa".contains("shw"));
        System.out.println("Vishwa".contains("phd"));


        String name1= new String("Vishwa");
        String name2 = new String("Vishwa");

        System.out.println(name1 == name2);// compares objects

        System.out.println(name1.equals(name2)); // Compares object values


        /**
         * I want to remove extra space from end
         */

        System.out.println(" I am Vishwa    ".trim());

        /**
         *
         */
        String fruits = "Apple,Banana,Grapes";

        String[] arr = fruits.split(",");

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(fruits.split("")));
    }
}
