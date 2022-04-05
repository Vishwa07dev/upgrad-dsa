package sorting;

public class TwentyNinethMarch {

    public void matchNutsAndBolts( char[] nuts, char[] bolts, int start, int end){
        if(start>=end){
            return;
        }

        int pivot = partition(nuts, start, end, bolts[end]);  // Partition first array

        partition(bolts, start, end, bolts[end]); // Partition second array

        matchNutsAndBolts(nuts,bolts, start, pivot-1);
        matchNutsAndBolts(nuts, bolts, pivot+1, end);


    }

    private int partition(char[] nuts, int start, int end, char pivotElement) {


        int i = start-1;
        for(int j=start;j<end;j++){
            if(nuts[j]<pivotElement){
                i++;
                char temp = nuts[j];
                nuts[j]=nuts[i];
                nuts[i]=temp;
            }else if(nuts[j]==pivotElement){
                char temp1 = nuts[j];
                nuts[j]=nuts[end];
                nuts[end]=nuts[j];
                j--;
            }

        }

        char temp = nuts[end];
        nuts[end]=nuts[i+1];
        nuts[i+1]= temp;
        return i+1;
    }
}
