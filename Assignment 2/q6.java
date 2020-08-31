import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class q6{
    //Array Methods
    static void Hailstone(int n){
        if(n==0) return;
        int count  = 0;
        while(n!=1){
            count++;
            if(n%2 == 0){
                System.out.println(n + " is Even :Dividing by 2");
                n /=2;
            }
            else{
                System.out.println(n + " is Even :Multiplying by 3 and adding 1");
                n = (n*3) + 1;
            }
        }
        System.out.println("Steps: "+ count);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        Hailstone(n);
        sc.close();
    }
}

