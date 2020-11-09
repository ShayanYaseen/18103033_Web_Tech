class Threaded2 extends Thread{

    private int range1;
    private int range2;

    //Set range
    public Threaded2(int range1,int range2){
        this.range1 = range1;
        this.range2 = range2;
    }

    //Count the number of divsiors of a number n
    public int countDivisors(int n){ 
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++){ 
            if (n % i == 0) { 
                if (n / i == i) count++; 
                else count = count + 2; 
            } 
        } 
        return count;
    } 

    @Override   
    public void run(){
        int most_divisors = 0;
        int ans = 1;
        for(int i=1;i<=range1;i++){
            int current_divisors = countDivisors(i);
            if(current_divisors>most_divisors){
                ans = i;
                most_divisors = current_divisors;
            }
        }
        System.out.println("The number in the range with most divisors is " + ans + "\nIt has divisors: "+ most_divisors);
    }
}

public class two{
    public static void main(String[] args){ 

        int range1 = 10000; 
        int range2 = 10000; 

        Threaded2 thread_object = new Threaded2(range1,range2);

        thread_object.start();
        
        try{
            thread_object.join();
        }catch(InterruptedException excptn){
            System.out.println(excptn);
        }
    }
}
