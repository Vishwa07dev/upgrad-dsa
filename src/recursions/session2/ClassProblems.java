package recursions.session2;

public class ClassProblems {

    /**
     * Usage of indirect recursion
     *
     * Print the numbers from 1 to 10 using indirect recursion
     */

    public static void print1(int num, int count){
        if(count>num){
            return;
        }
        System.out.println(count);

        print2(num, count++);  // count++ | count+1
    }

    private static void print2(int num, int count) {
        if(count>num){
            return;
        }

        System.out.println(count);

        print1(num, count+1);

    }

    /**
     * Find the factorial of a number in the tail recursive fashion
     *
     * tail recursive -> recursion should be the last step
     *
     */

    public static int factor(int num , int out){
        //Base condition
        if(num==0){
            return out;
        }
        return factor(num-1, out*num);  // recursion is the last step.
    }

    public static int moves(int n, char s , char d , char a){
        if(n==1){
            return 1;
        }

        return moves(n-1, s,a,d)+1+moves(n-1, a, d, s);
    }


    public static void main(String[] args) {
        print1(10, 1);

        System.out.println(factor(5,1));

        System.out.println(moves(2,'s','d','a'));
        System.out.println(moves(3,'s','d','a'));
        System.out.println(moves(4,'s','d','a'));


    }


}
