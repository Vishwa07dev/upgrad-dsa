package collectionframeworks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class April23 {


    public static void main(String[] args) {
        int[] arr = { 1,4,6,8,45,10};
        int targetElement = 17;

        printPairs(arr, targetElement);


        /**
         * HashSet
         */
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("Vishwa");
        hashSet.add("Mohan");
        hashSet.add("Abhishek");
        hashSet.add("Abhilasha");
        hashSet.add("Vishwa");

        System.out.println(hashSet);


        for(String names  : hashSet){
            System.out.println(names);
        }

        System.out.println(hashSet);


        /**
         * HashMap
         */

        /**
         * Creating a new HashMap
         */

        HashMap<Integer, String> map = new HashMap<>();  // 16 default capacity
        HashMap<Integer, String> map1 = new HashMap<>(64);

        /**
         * Inserting the data inside the HashMap
         *
         * put(k,v)
         */

        map.put(32, "Vishwa");
        map.put(45, "Mohan");

        System.out.println(map);

        /**
         * How do I search data
         *
         * With the help of key
         */
        System.out.println(map.get(32));
        System.out.println(map.get(33));

        /**
         * Interating over the HashMap
         */

        System.out.println(map.entrySet());
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        //Only want to iterate over the keys
        for(Integer key : map.keySet()){
            System.out.print(key + "  ");
        }
        System.out.println();

        //Only want to iterate over the values

        for(String value : map.values()){
            System.out.print(value + " ");
        }


    }

    private static void printPairs(int[] arr, int targetElement) {

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        for(int i=0;i<arr.length;i++){
            int temp = targetElement - arr[i];
            if(hashtable.keySet().contains(temp)){  // O(1)  AL contians - O(n)
                System.out.println("Pairs present : " + arr[i] + " : "+ (targetElement-arr[i]));
                return;
            }else{
                hashtable.put(arr[i],1);
            }

        }

        System.out.println("No such pair is presnet");
    }
}
