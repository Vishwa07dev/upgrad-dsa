package queue;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class April14 {


    class QueueUsingStack {

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        //O(1)
        public void enQueue(int data){
            stack1.push(data); //  O(1)
        }

        public int deQueue(){ // O(n)
            if(stack1.isEmpty()){
                throw new RuntimeException("Queue underflow exception");
            }
            //Move all the elements of stack1 to stack2

            while(!stack1.isEmpty()){  // O(n)
                stack2.push(stack1.pop());
            }
            int data = stack2.pop();
            //push back remaining elements of the stack2 into stack1

            while(!stack2.isEmpty()){  //O(n)
                stack1.push(stack2.pop());
            }

            return data;
        }
    }


    class StackUsingQueue {

        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        // O(1)
        public void push(int data){
            q1.add(data);
        }
        // O(n)
        public int pop(){

            int result  = 0 ;
            while(!q1.isEmpty()){
                int data = q1.remove();
                if(q1.isEmpty()){
                    result = data;
                    break;
                }
                q2.add(data);
            }

            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }

            return result ;
        }
    }
}
