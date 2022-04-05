package recursions.session1;

public class ClassProblems {

    /**
     * Recursive solution to find the factorial of a number
     */

    public static int fact(int n){
        //base condition
        if(n<=1){
            return 1 ;
        }

        //Logic and recursive
        return n*fact(n-1);
    }

    /**
     *
     * @param
     */

    public static int gcd(int num1, int num2){
        //Base condition
        if(num1==0){
            return num2 ;
        }
        if(num2==0){
            return num1;
        }

        if(num1>num2){
            return gcd(num1-num2, num2);
        }else{
            return gcd(num1, num2-num1);
        }
    }

    public static void main(String[] args) {
        System.out.println(fact(1));

        System.out.println(gcd(27,51));
    }

}
