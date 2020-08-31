import java.util.Arrays;
import java.util.Scanner;


public class q4{
    public static void main(String[] args){
        int sum = 0;
        int add_num = 1;
        System.out.println("The number where Σi = i^2 is ");
        while(add_num < Integer.MAX_VALUE){ //condition to check overflow
            sum += add_num;
            if(sum == add_num){
                System.out.println(sum);
            }
            add_num++;
            if(Integer.MAX_VALUE-add_num < sum){
                System.out.println("Avoiding Overflow");
                break;
            }
        }
        System.out.println("The biggest number just before overflow is: "+ add_num);
    }
}
