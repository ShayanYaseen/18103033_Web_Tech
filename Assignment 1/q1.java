import java.util.Arrays;
import java.util.Scanner;


public class q1{
    static boolean compare(String a,String b){
        System.out.println(a + " "+b);
        char ar[] = a.toCharArray();
        char br[] = b.toCharArray();
        Arrays.sort(ar);
        Arrays.sort(br);
        String sorted_a = new String(ar);
        String sorted_b = new String(br);
        return sorted_a.equals(sorted_b);
    }
    static int count(String a,String b){
        int n1 = a.length(),n2=b.length();
        if(n1 < n2) return 0;
        int ans = 0;
        for(int i=0;i<n1-n2;i++){
            if(compare(a.substring(i,i+n2),b)) ans++;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String searchstring = sc.nextLine();
        System.out.print("Enter a string: ");
        String key = sc.nextLine();
        System.out.println("Number of times the key occurs is: "+ count(searchstring,key));
    }
}
