//import java.util.Arrays;
import java.util.Scanner;


public class q2{
    static void counting_sort(int []nums){
        //count all elements frequency
        int count[] = new int[21];
        for(int element: nums){
            count[element]++;
        }
        int nums_pos = 0;
        int count_pos = 0;
        //Replacing original with sorted
        while(nums_pos<nums.length){
            if(count[count_pos]>0){
                for(int i=0;i<count[count_pos];i++){
                    nums[nums_pos++] = count_pos;
                }
            }
            count_pos++;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of input: ");
        int size = sc.nextInt();
        System.out.print("Enter a numbers: \n");
        int []nums = new int[size];
        for(int i=0;i<size;i++){
            int tmp = sc.nextInt();
            nums[i] = tmp;
        }
        System.out.println("Applying Counting Sort");
        counting_sort(nums);
        for (int element: nums)
            System.out.print(element + " ");
        sc.close();
    }
}
