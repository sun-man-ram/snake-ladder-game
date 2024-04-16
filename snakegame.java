import java.util.*;

public class snakegame{
    public static void main(String[] args){
        //taking input of no of players to be played-
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of players to be played");
        int a=sc.nextInt();
        int noofplayers=a;
        //now creating object arrays for given no of players corresponding to each player
        //objects are created under the name of players
        game[] player=new game[a+1] ;
        // memory allocated now instancing all these players in game class
        for(int i=1;i<=a;i++){
            player[i]=new game();
        }

        //using aggregation to communicate with snake and ladder classes

        Ladder ladder=new Ladder(10);
        Snake sarpam=new Snake(10);

        // getting ladder positions
        int[] lempo = new int[11];
        lempo=ladder.returnArray_beginnings();
        System.out.println("ladder beginning positions");
           for(int i=1;i<=10;i++){
               System.out.print(lempo[i]+ "\t");
           }
        System.out.println();
        int[] lempo1 = new int[11];
        lempo1=ladder.returnArray_endings();
        System.out.println("ladder ending positions");
           for(int i=1;i<=10;i++){
               System.out.print(lempo1[i]+ "\t");
           }
        System.out.println();
        //if at a position there is snake and a ladder, ladder is preferred
        //now getting snakes positions
        int[] tempo=new int[11];
        tempo=sarpam.getsnake_heads();
        System.out.println("snake head positions");
        for(int i=1;i<=10;i++){
            System.out.print(tempo[i]+ "\t");
        }
        System.out.println();
        int[] tempo1=new int[11];
        tempo1=sarpam.getsnake_Tail();
        System.out.println("snake tail positions");
        for(int i=1;i<=10;i++) {
            System.out.print(tempo1[i] + "\t");
        }
        System.out.println();
        System.out.println("Initial ppositions of the players");

            //to check whether the array of objects is instantiated correctly display all position
        // and if no null exceptions then the objects are instantiated correctly
        for(int i=1;i<=a;i++){
            System.out.println(player[i].display());
        }


        System.out.println("Let the game begin........");
//trying to make in a multiplayer game the loop have to break only








        //until all except one player had won the players positions is updated but fot the players who already won their
        //respective positions wont be updated
        //loop will be breakjed only if all except one has won
        while(true){

        //players positions will be updated in the order of their id
            for(int i=1;i<=noofplayers;i++){
        //this flag value indicated whether the player has won or not if he won his flag value will e 1 and his update won't happen
                if(player[i].flag==0){
                    player[i].roll();
                    player[i].position_update(tempo,tempo1,lempo,lempo1);
                }
       // display the current position of the player
                System.out.print("player  " + player[i].number() + "   current position  " + player[i].display());
                System.out.println("");
            }

            System.out.println("next round dice");
            System.out.println("");
            int count=0;

            //loop to check how many players won
            // everytime a player wins, the no of active players
            // is decreased and that of the won players is increased
            for(int i=1;i<=noofplayers;i++){
                if(player[i].win() == true){
                    count++;
                }
            }
            //if the won players number is equal to no of players-1 then the last player is considered lost and the game is terminated
            if(count==noofplayers-1){
                break;
            }
        }
    }
}