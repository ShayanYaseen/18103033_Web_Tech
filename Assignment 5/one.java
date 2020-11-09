
class Threaded extends Thread{

    private int count;
    private String string_var;

    public Threaded(int count,String string_var){
        this.count = count;
        this.string_var = string_var;
    }

    @Override   
    public void run(){
        //Count and print string
        for(int i=0;i<=count;i++){
            if(i!=0 && i%10==0) System.out.println(string_var);
            System.out.println(i + " ");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class one{
    public static void main(String[] args){     
        int count_until = 100; //Count upto 
        String string_var = "String";
        Threaded thread_object = new Threaded(count_until,string_var);

        thread_object.start();
        //Join the thread with main
        try{
            thread_object.join();
        }catch(InterruptedException excptn){
            System.out.println(excptn);
        }
    }
}
