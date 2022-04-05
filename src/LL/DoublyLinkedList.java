package LL;

public class DoublyLinkedList {


    /**
     * insert an element at the Kth index
     */
    public DLLNode insert(DLLNode head, int data, int k) {

        if (head == null) {
            return head;
        }

        if (k < 0 || k > length(head)) {

            throw new RuntimeException("k value passed is not correct");
        }
        DLLNode newNode = new DLLNode(data);

        if (k == 0) {
            //I need to add at the start
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else {
            DLLNode temp = head;
            int index = 0;
            while (index < k - 1) {
                temp = temp.getNext();
                index++;
            }
            temp.getNext().setPrev(newNode);
            newNode.setNext(temp.getNext());

            temp.setNext(newNode);
            newNode.setPrev(temp);
        }

        return head;


    }

    /**
     * Reverse a LL
     */

    public ListNode reverse(ListNode head){

        ListNode prev =null ;
        ListNode current = head ;

        while(current!=null){

            ListNode next = current.getNext();

            //Since I have to reverse
            current.setNext(prev);
            prev = current;
            current = next;
        }

        return prev ;
    }


    /**
     * Delete a node at the kth index in the case of DLL
     */

    /**
     * Update a DLL at the Kth index
     */


    /**
     * Traverse the DLL
     */
    public static void traverse(DLLNode head) {

        while (head != null) {
            System.out.print(head.getData() + " <==> ");
            head = head.getNext();
        }

        System.out.println();

    }

    /**
     * Length of the LL
     */

    public static int length(DLLNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.getNext();
        }

        return count;
    }


    /**
     * Write the code to insert element at the kth index in a DLL
     */


    public static void main(String[] args) {


        DLLNode node1 = new DLLNode(1);
        DLLNode node2 = new DLLNode(2);
        DLLNode node3 = new DLLNode(3);
        DLLNode node4 = new DLLNode(4);
        DLLNode node5 = new DLLNode(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setNext(node4);
        node3.setPrev(node2);
        node4.setNext(node5);
        node4.setPrev(node3);
        node5.setPrev(node4);

        traverse(node1);
        System.out.println(length(node1));


    }
}
