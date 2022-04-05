package LL;

public class LLMarchTenth {




    ListNode findMiddle(ListNode head){   // O(n)

        int length = LinkedList.length(head);  // 1 traversal  o(n)

        int midIndex = length/2 ;
        ListNode temp = head ;
        int index =0 ;

        while(index!=midIndex){  //traversing again  O(n)
            temp = temp.getNext();
            index++;
        }
        return temp ;
    }

    ListNode findMid(ListNode head){
        ListNode slow = head ;
        ListNode fast = head ;

        while(fast!=null && fast.getNext()!=null){
            slow = slow.getNext();
            fast= fast.getNext().getNext();

            if(fast==null|| fast.getNext()==null){
                return slow ; // this will be the mid point
            }
        }
        return slow ;
    }


    /**
     * Find if the LL has the loop of not
     */
    public static boolean hasLoop(ListNode head){
        if(head ==null || head.getNext()==null){
            return false ;
        }

        ListNode slow = head ;
        ListNode fast = head ;

        while(fast!=null && fast.getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if(fast.getData() == slow.getData()){
                return true;
            }
        }

        return false ;
    }

    /**
     * Start of the loop
     *
     */

    public static ListNode startOfLoop(ListNode head){
        if(head ==null || head.getNext()==null){
            return null ; // no loop itself
        }

        ListNode slow = head ;
        ListNode fast = head ;
        boolean hasLoop = false ;

        while(fast!=null && fast.getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if(fast.getData() == slow.getData()){
                hasLoop=true;
                break;
            }
        }
        //I know if the loop is present of not
        //if present I know the meeting point
        if(!hasLoop){
            return null;
        }

        /**
         * Distance from head to start of loop = distance from meeting point to start of loop
         */
        //Keep one at head
        // Keep other at meeting point

        ListNode first = head;
        ListNode second = slow ;

        while(first.getData()!= second.getData()){
            first = first.getNext();
            second= second.getNext();
        }

       return first;
    }

    /**
     *
     * @param
     */

    public static int count(int n){
        //BC
        if(n==1){
            return 0;
        }
        int total =1 ;

        for(int i=1;i<n/2+1 ;i++){
            total = total + count(n-i);
        }

        return total;
    }

    public static void main(String[] args) {

        System.out.println(count(1));
        System.out.println(count(2));
        System.out.println(count(3));
        System.out.println(count(4));
        System.out.println(count(5));






        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);


        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n4);

        System.out.println(hasLoop(head));
    }




















}
