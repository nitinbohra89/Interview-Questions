/**
 * Created by Nitin on 29/05/17.
 */
import java.util.Arrays;
public class WordOnIndex {

public static void main(String args[]){
    System.out.println(getWord("dcba",20));
}

    /*
    * Input-
    *   1. grammer - String to get all alphabets
    *   2. wordIndex- Integer word generated from that grammer on this index
    * Algorithm-
    *   1. Generate sorted string from the grammer
    *   2. Calculate total number of words generated from the grammer
    *   3. find out the character for each position
    * Example - if grammer=dcba  and wordIndex=20
    *      then sorted string from the grammer - abcd
    *      total words generated from this grammer of length 4 = factorial(4)=24
    *      to identify the first letter lets check if first letter is constant then total no. of words generated = factorial(3)=6
    *      Similarly will check for each index.
    * */

    public static String getWord(String grammer, int wordIndex){
        char[] alphabet=grammer.toCharArray();
        Arrays.sort(alphabet);
        grammer=String.copyValueOf(alphabet);
        String indexString=new String();
        while(grammer.length()>0){
            int numWords=getFactorial(grammer.length()-1);
            if(wordIndex%numWords==0){
                int index=wordIndex/numWords-1;
                indexString+=grammer.charAt(index);
                grammer=reverse(grammer.substring(0, index)+grammer.substring(index+1));
                return (indexString+grammer);
            }else{
                int index=wordIndex/numWords;
                indexString+=grammer.charAt(index);
                grammer=grammer.substring(0, index)+grammer.substring(index+1);
                wordIndex-=numWords*index;
            }
        }
        return null;
    }



    /*
    * Calculate the factorial of passed value
    * factorial(3)=3*2*1=6
    * */
    public static int getFactorial(int x){
        int temp=1;
        for(int i=1;i<=x;i++){
            temp*=i;
        }
        return temp;
    }

    /*
    * Reverse the string
    * Input : abcd
    * Output: dcba
    * */
    public static String reverse(String x){
        StringBuilder s=new StringBuilder();
        for(int i=x.length()-1;i>=0;i--){
            s.append(x.charAt(i));
        }
        return s.toString();
    }

}
