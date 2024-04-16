import java.lang.Math;
public class game implements methodsingame{
    //static instance to assign the number of players
    static int variable=1;
    //using static variable each player will get a unique number which represents them
    int number;
    //shows where the player currently is
    int position;
    //checks whether the player has won or not if won he will have a flag 1 and 0 if he didn't win yet
    int flag;
    //if player won used to display their rank
    int rank=0;
    //constructor to initiate the variables of a player and update the static part of the class
    public game(){
        number=variable;
        position=0;
        flag=0;
        variable++;
        rank=0;
    }
    //method to display the position of player who called
    public int display(){
        return this.position;
    }
    //method to display the unique number of player which is his or her kind of id
    public int number(){
        return this.number;
    }

    //method to find whether the player has won or not if he won his position won't be updated
    public boolean win(){
        if(this.position==100){
            this.flag=1;
            System.out.println("WON!!!  player"+this.number+" at  100");
            return true;
        }
        else{
            return false;
        }
    }
    /* here we are rolling the dice and max number is 6 which happens and this logic can sustain only till
       3 consecutive 6 comes for one particular player and after that the player cant move multiple time
       even he gets 6 next*/

    // method used to find the die number when rolled,uses general random function unlike cryptographically
    // generates 1 to 6 and also makes a count if the die
    // number got 6, 3 consecutive times
    public void roll(){
        int die_number=(int)(Math.random() * 6) + 1;
        if(die_number==6){
            position=position+6;
            if(position>100){
                position=position-6;
            }
            die_number=(int)(Math.random() * 6) + 1;

            if(die_number==6){
                position=position+6;
                if(position>100){
                    position=position-6;
                }
                die_number=(int)(Math.random() * 6) + 1;
                position=position+die_number;
                if(position>100){
                    position=position-die_number;
                }
            }
            else{

                position=position+die_number;
                if(position>100){
                    position=position-die_number;
                }
            }
        }
        else{

            position=position+die_number;
            if(position>100){
                position=position-die_number;
            }
        }

    }
    //the above function also updates the position of the player but the below one
    // checks whether the updated position has any snake or ladder
    // in their respective positions and update position accordingly
    // if there is a snake head and ladder, ladder will be given preference in the motto of constructiveness
    public void position_update(int[] tempo,int[] tempo1,int[] lempo,int[] lempo1){


        //now after getting the snakes and ladders position, after rolling the die we will move to a point
        //now we have to look whether this point is having snakes or this point is having any ladder and correspondingly we have to update the position.
        //if there is a ladder then point the position to ladder_ending
        //if there is a snake at position point the position to get snake tail
        //if there is a tie between ladder and snake we prefer ladder in easy version and snake in hard version

        for(int i=1;i<=10;i++){
            if(position==lempo[i]){
                position=lempo1[i];
                break;
            }
        }
        for(int i=1;i<=10;i++){
            if(position==tempo[i]){
                position=tempo1[i];
                break;
            }
        }

    }
}