package stacks;

import java.util.Stack;

public class April19 {

    /**
     * Calculate the stock span
     * @param args
     */

    public static int[] calculateSpan(int[] stockPrices){
        int[] span = new int[stockPrices.length];

        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0]=1;

        for(int i=1;i<stockPrices.length;i++){

            //Till the stack is not empty and top element is less than ith element
            while(!s.isEmpty() && stockPrices[s.peek()] <= stockPrices[i]){
                s.pop();
            }

            span[i] = s.isEmpty()? i+1: i-s.peek();
            s.push(i);
        }

        return span;
    }


    public static void main(String[] args) {

        boolean[][] relations = {
                {false, false, true, false},
                {false, false, true, false},
                {false, false, false, false, false},
                {false, false, true, false}

        };

        System.out.println(findCelebrity(4, relations));
    }

    private static int findCelebrity(int num, boolean[][] relations) {
        Stack<Integer> s = new Stack<>();

        /**
         *  I need to fill the stack with all persons
         */
        for(int i=0;i<num;i++){
            s.push(i);
        }

        while(s.size()>1){  // n
            int a = s.pop();
            int b= s.pop();

            if(relations[a][b]){
                //a knows b
                s.push(b);
            }else{
                //b can never be the celebrity
                s.push(a);
            }
        }

        //It should have 1 element left
        int c = s.pop();

        //I need to check if he is really celebrity
        for(int i=0;i<num;i++){
            if(i!=c){
                if(!relations[i][c] || relations[c][i]){
                    return -1;
                }
            }
        }

        return c ;

    }


}
