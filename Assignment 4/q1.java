import java.util.Scanner;

class q1 {
    public static void main(String[] args)
    {
        int n,m;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter n");
        n = in.nextInt();
        System.out.println("Enter m");
        m = in.nextInt();
        in.nextLine(); //Consuming the \n introduced from nextInt()

        String[] crops = new String[n];
        for (int i=0;i<n;i++){
            System.out.println("Enter crops in line " + i);
            String tmp = in.nextLine();
            tmp.trim();
            crops[i] = tmp;
        }
        in.close();

        //Testing
        /*
        String[] crops = {"acaa",
                "dddd",
                "bbbb",
                "cece"
        };
        */
        System.out.print(replant(crops));

    }
    public static char differentCrop(String[] crops,int a,int b){
        char top = 'A',bottom='A',left='A',right='A';
        char current = crops[a].charAt(b);
        int n = crops.length,m = crops[0].length(); // size of grid

        //storing the nearby crops character
        if(a!=0) top = crops[a-1].charAt(b);
        if(a!=n-1) bottom = crops[a+1].charAt(b);
        if(b!=0) left = crops[a].charAt(b-1);
        if(b!=m-1) right = crops[a].charAt(b+1);

        //checking if all neighboruing are same
        if((current!=top)&&(current!=bottom)&&(current!=left)&&(current!=right)){
            return current;
        }
        else{
            char c;
            for(c = 'a'; c <= 'z'; ++c){
                if((c!=top)&&(c!=bottom)&&(c!=left)&&(c!=right)){
                    current = c;
                    break; // Changing the crop as per requiremnts
                }
            }
        }
        return current;
    }
    public static int replant(String[] crops){
        // Write your code here
        // Return the number of replanted crops
        int n = crops.length,m = crops[0].length();

        String[] crops_old = new String[n];
        int ptr = 0;
        for (String x : crops){
            crops_old[ptr] = x;
            ptr++;
        }

        System.out.println("Crop Field right now");
        for (String x : crops){
            System.out.println(x);
        }
        System.out.println("Crop changing");

        boolean flag = true; // if all crops are correctly placed
        while(flag){
            boolean currentpass = true;
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    char current = crops[i].charAt(j);
                    char changed = differentCrop(crops,i,j);

                    if(current!=changed) currentpass = false;
                    else continue;

                    //editing the string array
                    String tmp = crops[i];
                    char[] tmp_array = tmp.toCharArray();
                    tmp_array[j] = changed;
                    tmp = String.valueOf(tmp_array);

                    crops[i] = tmp;
                }
            }
            if(currentpass == true) break; // if no crops changed in this pass
        }

        System.out.println("Crop Field changed");
        for (String x : crops){
            System.out.println(x);
        }

        int no_of_changes = 0; //no of change in field

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++) {
                if(crops_old[i].charAt(j) != crops[i].charAt(j)) no_of_changes++;
            }
        }
        System.out.println("The no of changes are");
        return no_of_changes;
    }
}
