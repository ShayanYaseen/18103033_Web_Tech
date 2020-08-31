import java.util.Arrays;
import java.util.Scanner;


public class q3{
    static void SortString(String str){
        //Counting Sort
        int[] char_freq = new int[256];
        for(char element : str.toCharArray()){
            char_freq[element - '!']++;
        }
        for (int i = 0; i < 256; i++) { 
            for (int j = 0; j < char_freq[i]; j++) { 
                System.out.print((char) (i + '!')); 
            } 
        } 
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputstring = sc.nextLine();
        System.out.println("Sorted String");
        SortString(inputstring);
    }
}
