package collectionframeworks;

import LL.LinkedList;
import LL.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class April24 {


    public static boolean isSubset(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        for(int j=0;j<arr2.length;j++){
            if(!set.contains(arr2[j])){
                return false ;
            }
        }

        return true ;
    }

    static class Pair {
        private int firsNumber ;
        private int secondNumber;

        public Pair(int firsNumber, int secondNumber) {
            this.firsNumber = firsNumber;
            this.secondNumber = secondNumber;
        }

        public int getFirsNumber() {
            return firsNumber;
        }

        public void setFirsNumber(int firsNumber) {
            this.firsNumber = firsNumber;
        }

        public int getSecondNumber() {
            return secondNumber;
        }

        public void setSecondNumber(int secondNumber) {
            this.secondNumber = secondNumber;
        }
    }

    public boolean doesPairExist(int[] arr){
        HashMap<Integer, Pair> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum = arr[i]+arr[j];

                if(map.containsKey(sum)){
                    Pair p = map.get(sum);
                    System.out.println("Numbers are ( " + arr[i]+ "," +arr[j]+") ("+ p.getFirsNumber() +","+ p.getSecondNumber()+ " )");
                    return true;
                }else{
                    map.put(sum, new Pair(arr[i],arr[j]));
                }
            }
        }
        return false;
    }







    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head1.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);


        ListNode head2 = new ListNode(1);

        head2.setNext(new ListNode(7));

        head2.getNext().setNext(new ListNode(2));

        head2.getNext().getNext().setNext(new ListNode(4));

        LinkedList.traverse(head1);
        LinkedList.traverse(head2);

        ListNode result = union(head1, head2);

        LinkedList.traverse(result);// This will contain the union of two LLs


    }

    private static ListNode union(ListNode head1, ListNode head2) {

        HashMap<Integer, ListNode> map = new HashMap<>();

        ListNode temp = head1 ;

        while(temp !=null){
            map.put(temp.getData(), temp);
            temp = temp.getNext();
        }
        temp = head2;

        while(temp!=null){
            map.put(temp.getData(), temp);
            temp = temp.getNext();
        }

        ListNode resultHead = null;
        ListNode prev = null;
        System.out.println(map.values());

        int count =0;
        int max = map.values().size();
        for(ListNode node : map.values()){
            if(resultHead==null){
                resultHead = node ;
                prev = node ;
            }else{
                prev.setNext(node);
                prev= prev.getNext();
            }
            count++;
            if(count==max){
                node.setNext(null);
            }
        }
        System.out.println("Out of for loop");
        return resultHead;
    }
}
