package Strings;

public class AprilSeventh {


    public static void permutations(String str, int left, int right){
        //Base condition
        if(left == right){
            System.out.println(str);
            return;
        }

        // Find all the possible permutations of the string
        // With the help of Swapping

        for(int i=left ; i<=right;i++){
            // Swap the characters left and i
            str = swapCharacters(str, left, i);
            permutations(str, left+1, right);
            str= swapCharacters(str, left, i);

        }

    }

    public static boolean patternPresent(char[][] grid, String word){

        //Search for the first character of the word

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]==word.charAt(0)){
                    //need to look for the neighbours
                    boolean isPresent = true; //searchInMatrix(grid, row, col, word);
                    if(isPresent){
                        return true;
                    }
                }
            }
        }

        return false ;
    }

    private static boolean searchInMatrix(char[][] grid, int row, int col, String word){

        if(grid[row][col]!=word.charAt(0)){
            return false ;
        }
        //Check for all the neighbours
        int[] x = {-1,-1,-1, 0,0, 1,1,1};
        int[] y = {-1, 0, 1,-1,1,-1,0,1};

        for(int dir =0;dir<8;dir++){
            int nextR = row+x[dir];
            int nextC = col + y[dir];
            int k=1; // which indicates the number of characters found in the matrix

            for(k=1;k<word.length();k++){
                //Validate the nextR and nextC
                if(nextR>=grid.length || nextR<0 || nextC >=grid[0].length || nextC<0){
                    break;
                }
                if(grid[nextR][nextC] != word.charAt(k)){
                    break;
                }
                nextR = nextR + x[dir]; //
                nextC = nextC + y[dir]; // i.e find the next possible row and column

            }
            if(k==word.length()){
                return true;
            }
        }

        return false ;
    }




    private static String  swapCharacters(String str, int i, int j) {

        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return new String(arr);

    }


    public static void main(String[] args) {
        String str = "abcd" ;

        permutations(str,0,str.length()-1);


    }
}
