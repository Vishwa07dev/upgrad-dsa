package stacks;

import LL.ListNode;

public class April9th {

}


class StackUsingLL {

    private ListNode head ; // at this both push and pop should happen


    /**
     * isEmpty
     */
    public boolean isEmpty(){
        return head == null ;
    }

    /**
     * isFull() - Not required
     */

    public void push(int data){
        ListNode node = new ListNode(data);
        node.setNext(this.head);
        this.head = node;
    }

    public int pop(){

        if(isEmpty()){
            throw new RuntimeException("Stack underflow exception");
        }
        int data = head.getData();
        head = head.getNext();
        return data ;
    }
}





class Stack {
    private int[] arr ;
    private int capacity ;
    private int top ;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1 ; // indicates stack is empty in the begining


        //top indicates the index of the latest element added
    }


    /**
     * isEmpty
     * O(1)
     */
    public boolean isEmpty(){
       /** if(top==-1){
            return true;
        }
        return false ; **/

       return top==-1;


    }


    /**
     * isFull
     *  O(1)
     */
    public boolean isFull(){
        return top == capacity-1;
    }


    /**
     * push
     *  O(1)
     */
    public void push(int data){
        /**
         * check if it's already full
         */
        if(isFull()){
            throw new RuntimeException("Stack overflow exception");
        }
        this.arr[++top] = data;
    }

    /**
     * pop
     *  O(1)
     */

    public int pop(){
        /**
         * check if it's empty
         */
        if(isEmpty()){
            throw new RuntimeException("Stack underflow exception");
        }
        return this.arr[top--];
    }

    /**
     * peek
     *  O(1)
     *
     * We just need to know, what is at the peak
     */
    public int peek(){
        /**
         * check if it's empty
         */
        if(isEmpty()){
            throw new RuntimeException("Stack underflow exception");
        }

        return this.arr[top];
    }
}
