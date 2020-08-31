import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class q5{
    //Array Methods
    static void array_method_union(int[] a,int[] b){
        int[] count = new int[11];
        for(int elmt : a) count[elmt]++; 
        for(int elmt : b) count[elmt]++; 
        System.out.println("Union of Sets is");
        for(int i=0;i<11;i++){
            if(count[i]>0) System.out.print(count[i]+ " ");
        }
    }
    static void array_method_intersection(int[] a,int[] b){
        int[] count = new int[11];
        for(int elmt : a) count[elmt]++; 
        for(int elmt : b) count[elmt]++; 
        System.out.println("\nIntersection of Sets is");
        for(int i=0;i<11;i++){
            if(count[i]>1) System.out.print(count[i]+ " ");
        }
    }
    static void array_method_complement(int[] a){
        int[] count = new int[11];
        for(int elmt : a) count[elmt]++; 
        System.out.println("\nComplement of Set is");
        for(int i=0;i<11;i++){
            System.out.print(count[i]+ " ");
        }
    }
    static void array_method(int[] a,int[] b){
        array_method_union(a, b);
        array_method_intersection(a, b);
        array_method_complement(a);
        array_method_complement(b);
    }
    //Hash Map Methods
    static void ds_method_union(Set<Integer> a,Set<Integer> b){
        System.out.println("\nUnion of Sets is");
        for(int i=0;i<11;i++)
            if(a.contains(i) || b.contains(i)) System.out.print(i+ " ");
    }
    static void ds_method_intersection(Set<Integer> a,Set<Integer> b){
        System.out.println("\nIntersection of Sets is");
        for(int i=0;i<11;i++)
            if(a.contains(i) && b.contains(i)) System.out.print(i+ " ");
    }
    static void ds_method_complement(Set<Integer> a){
        System.out.println("\nComplement of Set is");
        for(int i=0;i<11;i++)
            if(!a.contains(i)) System.out.print(i+ " ");
    }
    static void ds_method(Set<Integer> a,Set<Integer> b){
        ds_method_union(a, b);
        ds_method_intersection(a, b);
        ds_method_complement(a);
        ds_method_complement(b);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in set a");
        int size_a = sc.nextInt();
        int[] a = new int[size_a];
        System.out.println("Enter elements in set a");
        for(int i=0;i<size_a;i++)
            a[i] = sc.nextInt();
        System.out.println("Enter number of elements in set b");
        int size_b = sc.nextInt();
        int[] b = new int[size_b];
        System.out.println("Enter elements in set b");
        for(int i=0;i<size_b;i++)
            b[i] = sc.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        //convert to hset
        Set<Integer> aset = new HashSet<Integer>(); 
        for(int elements: a) aset.add(elements);

        Set<Integer> bset = new HashSet<Integer>(); 
        for(int elements: b) bset.add(elements);
        //Measurign time        
        long startTime = System.nanoTime();

        array_method(a,b);

        long stopTime = System.nanoTime();
        System.out.println("Time taken by array method");
        System.out.println(stopTime - startTime);
        startTime = System.nanoTime();

        ds_method(aset,bset);

        stopTime = System.nanoTime();
        System.out.println("Time taken by Data Structure(Hash) method");
        System.out.println(stopTime - startTime);
        System.out.println("Time is in nano seconds");
        sc.close();
    }
}

