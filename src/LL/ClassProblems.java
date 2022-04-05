package LL;

public class ClassProblems {


    public static ListNode reverse(ListNode head){

        if(head ==null || head.getNext()==null){
            return head ;
        }
        ListNode newHead = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }


    public static ListNode pairWiseReverse(ListNode head){

        if(head ==null || head.getNext()==null){
            return head ;
        }

        ListNode finalHead = head.getNext();

        /**
         * Logic for reversing the LinkedList
         */

        while(true){

            if(head.getNext()==null || head.getNext().getNext()==null){
                break;
            }

            ListNode next = head.getNext().getNext();
            /**
             * Need to reverse the head and headNext
             */
            head.getNext().setNext(head);
            head.setNext(next);
            head=next;
         }

        return finalHead;

    }


    public static ListNode reverseK(ListNode head , int k){
        if(head==null || head.getNext()==null){
            return head;
        }
        ListNode current = head ;
        ListNode prev = null;
        ListNode next = null;
        int count =0; // refers the number of elements which has to be reversed

        while(count<k && current!=null){
            next = current.getNext();
            current.setNext(prev);
            prev=current;
            current=next;
            count++;
        }

        //At this point first k elements would have got reversed
        /**
         *  1 ->2 ->3 ->4 ->5->6->7->8
         * 3->2->1  4->5->6->7->8
         *prev = 3 , current = 4 = next
         *head = 1
          I would like to set 1 next to the reverseK of (4->5->6->7->8)
         *
         */

        if(next!=null){
           head.setNext(reverseK(next, k));
        }
        return prev;
    }

    /**
     * Clone a linkedList
     */

    public ListNodeM clone(ListNodeM head) {

        ListNodeM[][] arr = new ListNodeM[5][2];

        ListNodeM current = head ;
        int i=0;
        while(current!=null){
            arr[i][0]= current;
            arr[i][1] = new ListNodeM(current.getData());//cloned ListNode
        }
        current = head;
        i=0;
        while(current !=null){
            ListNodeM cloned = arr[i][1];
            ListNodeM next = current.getNext();

            ListNodeM random = current.getRandom();

            ListNodeM clonedNext = arr[next.getData()-1][1];

            ListNodeM clonedRandom = arr[random.getData()-1][1];

            cloned.setNext(clonedNext);
            cloned.setRandom(clonedRandom);
        }

        return arr[0][0];
    }


    /**
     * Split  a given LL into two
     */

    public static void breakLL(ListNode head) {
        ListNode head1 = head ;

        ListNode head2 = head.getNext();

        /**
         * Write the logic to separate the given LL into two
         *
         * 1->2->3->4->5->
         */

        while(head1 !=null){
            head1.setNext(head1.getNext().getNext());  // 1->3

            head2.setNext(head2.getNext().getNext()); // 2 ->4

            head1 = head1.getNext();
            head2 = head2.getNext();
        }

        LinkedList.traverse(head1);
        LinkedList.traverse(head2);
    }

    /**
     * Traversing a CLL
     */

    public static void traverse(ListNode head){
        if(head==null){
            return ;
        }

        System.out.print(head.getData() + "  ");
        ListNode temp = head.getNext();

        while(temp.getData() != head.getData()){

            System.out.print(temp.getData() + "  ");
            temp = temp.getNext();
        }
    }



    public static ListNode addOne(ListNode head){

        //Reverse
        head = reverse(head);

        ListNode res = head ;

        /**
         * Adding 1 to the LL
         */
        ListNode temp =null, prev = null;
        int carry =1 ;//because we have to add 1 to the num
        int sum;

        while(head !=null){
            sum = carry + head.getData();

            carry = sum>=10 ? 1 : 0;
            sum = sum%10;
            head.setData(sum);
            temp = head;
            head= head.getNext();
        }
        if(carry !=0){
            temp.setNext(new ListNode(carry));
        }

        /**
         * Reverse it again before returning
         */
        return reverse(res);
    }

    public static void main(String[] args) {
        ListNode node1  = new ListNode(1);
        ListNode node2  = new ListNode(2);
        ListNode node3  = new ListNode(3);
        ListNode node4  = new ListNode(4);
        ListNode node5  = new ListNode(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        ListNode head = pairWiseReverse(node1);

        traverse(head);  // Normal traversal
    }


}

class ListNodeM {
    private int data;

    private ListNodeM next ;
    private ListNodeM random ;

    public ListNodeM(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNodeM getNext() {
        return next;
    }

    public void setNext(ListNodeM next) {
        this.next = next;
    }

    public ListNodeM getRandom() {
        return random;
    }

    public void setRandom(ListNodeM random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "ListNodeM{" +
                "data=" + data +
                '}';
    }
}


