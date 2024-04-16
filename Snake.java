import java.security.SecureRandom;
public class Snake{
    int[] snake_Head;
    int[] snake_Tail;
    public Snake(int a){
        //cryptographically generated heads and tails with boundaries so that overlapping of heads positions and tails positions is very low
        //in their respective boundaries.
        SecureRandom rand = new SecureRandom();
        snake_Head=new int[a+1];
        snake_Tail=new int[a+1];
        for(int i=1;i<=a;i++){
            snake_Tail[i]=rand.nextInt(45)+1; //randomly assigns the tail of the snake in the region 1 to 45
            snake_Head[i]=rand.nextInt(40)+49; //randomly generated heads of the snake in the region 49 to 99
        }
    }

    // methods that return snake heads and tails respectively which are generated randomly
    public int[] getsnake_heads(){
        return snake_Head;
    }
    public int[] getsnake_Tail(){
        return snake_Tail;
    }
}