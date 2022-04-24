package stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class April11th {

    public static boolean isBalanced(char[] arr){
        // Using stack available in collection framework
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<arr.length;i++){

            if(arr[i]=='{'||arr[i]=='('||arr[i]=='['){
                stack.push(arr[i]);
            }else{
                //If the stack is empty
                if(stack.isEmpty()){
                    return false ;
                }else{
                    char bracket = stack.pop();
                    if(isMatching(bracket, arr[i])){
                        continue;
                    }else{
                        return false;
                    }

                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatching(char bracket1, char bracket2) {
         return ((bracket1=='(' && bracket2 ==')') || (bracket1=='{' && bracket2 =='}') ||
                 (bracket1=='[' && bracket2 ==']'));
    }


    public static void main(String[] args) {


        System.out.println(isBalanced("{{[]}}".toCharArray()));
        System.out.println(isBalanced("}{".toCharArray()));
//        java.util.Stack<Integer> s = new java.util.Stack<>();
//        s.push(4);
//        s.push(12);
//        s.push(10);
//        s.push(21);
//        System.out.println(s);

        //Insert 11 at the end of the array

//        reverseStack(s);
//
//        System.out.println(s); // [ 11,4,12,10,21]
    }

    private static void reverseStack(Stack<Integer> stack) {

        if(stack.isEmpty()){
            return;
        }
        int data = stack.pop();
        reverseStack(stack);
        insertAtTheEnd(stack,data);
    }

    private static void insertAtTheEnd(Stack<Integer> stack, int num) {

        //Base condition
        if(stack.isEmpty()){
            stack.push(num);
        }else{
            int elem = stack.pop();
            insertAtTheEnd(stack,num);
            stack.push(elem);
        }

    }


}
