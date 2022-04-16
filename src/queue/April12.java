package queue;

import LL.ListNode;

public class April12 {


    public static int timeForMangoesToRot(int[][] mangoes){
        int num = 2; // num indicates rotten mango
        boolean hasRottenInCurrentCycle = false ;

        while(true){
            /**
             * Iterate over the entire list of Mangoes
             */

            for(int i=0;i<mangoes.length;i++){
                for(int j=0;j<mangoes[0].length;j++){
                    if(mangoes[i][j]==num){
                        //right
                        if(j+1<mangoes[0].length && mangoes[i][j+1]==1){
                            mangoes[i][j+1]= num+1;
                            hasRottenInCurrentCycle = true;
                        }

                        //left
                        if(j-1>=0 && mangoes[i][j+1]==1){
                            mangoes[i][j-1]= num+1;
                            hasRottenInCurrentCycle = true;
                        }
                        //top
                        if(i-1>=0 && mangoes[i-1][j]==1){
                            mangoes[i-1][j]= num+1;
                            hasRottenInCurrentCycle = true;
                        }
                        //bottm
                        if(i+1<mangoes.length && mangoes[i+1][j]==1){
                            mangoes[i+1][j]= num+1;
                            hasRottenInCurrentCycle = true;
                        }
                    }
                }
            }
            if(!hasRottenInCurrentCycle){
                break;
            }
            hasRottenInCurrentCycle= false;// reset the value for the next cycle
            num++;
         }

        return num-2;// this will indicate the number of days

    }

}


class QueueLL {
    private ListNode head ;
    private ListNode tail ;

    public boolean isEmpty(){
        return head ==null;
    }

    public void enQueue(int data){
        ListNode node = new ListNode(data);

        if(isEmpty()){
            head = node;
            tail= node;
        }else{
            tail.setNext(node);
            tail = tail.getNext();
        }
    }

    public int deQueue(){
        int data = head.getData();
        if(head==tail){
            head = null;
            tail= null;
        }else{
            head = head.getNext();
        }
        return data ;
    }

}

class Queue {

    int[] arr ;
    int capacity;
    int f ;
    int r ;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        f=-1;
        r=-1;
    }

    /**
     * isEmpty
     */
    public boolean isEmpty(){
        return f==-1;
    }

    /**
     * isFull
     */
    public boolean isFull(){
        return (f+1)%capacity == r ;
    }

    /**
     * enQueue
     */
    public void enQueue(int data){

        if(isFull()){
            throw new RuntimeException("Queue overflow exception");
        }
        f= (f+1)%capacity;
        this.arr[f] = data;

        if(r==-1){
            r=f;
        }
    }
    /**
     * Deque
     */
    public int deQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue underflow exception");
        }
        int data = arr[r];
        if(f==r){
            //This is the last element
            f=-1;
            r=-1;
        }else{
            r= (r+1)%capacity;
        }

        return data;

    }


}
