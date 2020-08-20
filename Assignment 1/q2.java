import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class q2{
    public static String replace(String str,String[] array){
        String[] ary = str.split((" "));
        for (int i = 0; i < ary.length; i++)
            System.out.println(ary[i]);
        
        Set<String> hash_Set = new HashSet<String>();
        for (int i = 0; i < array.length; i++)
            hash_Set.add(array[i]);
        
        for (int i = 0; i < ary.length; i++){
            if(hash_Set.contains(ary[i])){
                char[] tmp = ary[i].toCharArray();
                for(int j=1;j<tmp.length;j++) tmp[j] = '*';
                ary[i] = new String(tmp);
            }
        }
        

        String ans = "";
        for (int i = 0; i < ary.length; i++)
            ans += ary[i] + " ";
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter a number of keys to be remove: ");
        int n = sc.nextInt();
        System.out.print("Enter the keys: ");
        String[] array = new String[n+1];
        for(int i=0;i<=n;i++){
            array[i] = sc.nextLine();
        }
        System.out.println(replace(str,array));
    }
}
