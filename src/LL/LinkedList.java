package LL;

public class LinkedList {


    public static void traverse(ListNode head){ // TC : O(n)

        while(head !=null){
            System.out.print(head.getData() + " -> ");
            //Move to the next node
            head = head.getNext();//jump to the next node
        }
        System.out.println();

    }

    /**
     * Find the length of the given LL
     *
     */

    public static int length(ListNode head){ // O(n)
        //find the length of the LL

        int len =0;
        while(head!=null){
            len++;
            head = head.getNext();

        }
        return len;
    }


    /**
     * Search if an element exist in the LL or not
     *
     */

    public boolean isPresent(ListNode head , int data){
        /**
         * return true if present
         * else return false
         */
        while(head!=null){
            if(head.getData()==data){
                return true;
            }
            head = head.getNext();
        }
        return false ;
    }


    /**
     * code to insert an element in the LL at the kth position
     *
     */
    public static ListNode insertAtKthPosition(ListNode head, int data, int k){
        //Arguments are valid
        if(k<0 || k>length(head)){
            System.out.println("K value passed is invalid");
            return head ;
        }

        ListNode newNode = new ListNode(data);
        if(k==0){
            //We need to add the element at the start
            newNode.setNext(head);
            head = newNode;
        }else{
            int index =0;
            ListNode temp = head;
            while(index < k-1){
                temp = temp.getNext();
                index++;
            }
            // temp will be at the node one before the target node
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        return head ;
    }


    public static ListNode delete(ListNode head , int k){
       return null ;
    }

    public static ListNode  upated(ListNode head, int k, int data){
    return null ;
    }


    public static void main(String[] args) {


        /**
         * LL is the collection of ListNode
         */

        ListNode head  = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        //Creating LL
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        //LL is created

        traverse(head);

        System.out.println(length(head));

        ListNode newHead = insertAtKthPosition(head, 9, 0) ;

        traverse(newHead);

        traverse(insertAtKthPosition(newHead, 11, 4));

        traverse(insertAtKthPosition(head, 13, 25));
    }
}
