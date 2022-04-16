package stacks;

import java.util.Stack ;

public class April16 {

    public static void main(String[] args) {
        System.out.println(evaluatePrefix("+7*29"));
    }

    private static double evaluatePrefix(String prefix) {

        //Stack will contain the operands ( double )
        Stack<Double> stack = new Stack();

        //Start iterating from the last character

        for(int i=prefix.length()-1;i>=0;i--){
              if(isOperand(prefix.charAt(i))) {
                  stack.push(convertCharToDouble(prefix.charAt(i)));
              }else {
                  /**
                   * POP two elements from stack
                   */
                  double op1 = stack.pop();
                  double op2 = stack.pop();

                  switch( prefix.charAt(i)) {
                      case '+':
                          stack.push(op1 + op2);
                          break;
                      case '-':
                          stack.push(op1 - op2);
                          break;
                      case '*':
                          stack.push(op1 * op2);
                          break;
                      case '/':
                          stack.push(op1 / op2);
                          break;
                  }
              }
            }
            return stack.peek();
        }

    private static Double convertCharToDouble(char c) {
         return  (double)(c-48);
    }

    private static boolean isOperand(char c) {
          return c >=48 & c<=57;
    }
}

