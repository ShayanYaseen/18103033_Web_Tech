//import java.util.Arrays;
import java.util.Scanner;


public class q1{
    static int compare(String a,String b){
        //Compare string untill they are of equal length
        for (int i = 0; i < a.length() &&  i < b.length(); i++) { 
            if ((int)a.charAt(i) ==  (int)a.charAt(i)) continue; 
            return (int)a.charAt(i) - (int)b.charAt(i); 
        } 
        //Case if not equal length
        if (a.length() < b.length())
            return (a.length()-b.length()); 

        else if (a.length() > b.length())
            return (a.length()-b.length()); 
        
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String searchstring = sc.nextLine();
        System.out.print("Enter a string: ");
        String key = sc.nextLine();
        System.out.println("The two strings are lexicographically compared as : "+ compare(searchstring,key));
        sc.close();
    }
}

