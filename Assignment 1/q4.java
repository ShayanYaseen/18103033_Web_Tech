import java.util.Arrays;
import java.util.Scanner;

public class q4 {
    static boolean compare(String a, String b) {
        //System.out.println(a + " " + b);
        char ar[] = a.toCharArray();
        char br[] = b.toCharArray();
        Arrays.sort(ar);
        Arrays.sort(br);
        String sorted_a = new String(ar);
        String sorted_b = new String(br);
        return sorted_a.equals(sorted_b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String searchstring = sc.nextLine();
        System.out.print("Enter a string: ");
        String key = sc.nextLine();
        System.out.println("Are they anagram" + "\n" + compare(searchstring, key));
    }
}
