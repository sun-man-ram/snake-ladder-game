// package containing cryptographical random generator function
//here we have used other random function than normal one because two ladders should not be at
//same place hence created a rand function cryptographically have very low chances of
//repetiton https://www.educative.io/answers/how-to-generate-random-numbers-in-java
import java.security.SecureRandom;
public class Ladder{
    int[] ladder_beginnings;
    int[] ladder_endings;

    // cryptographically generated heads and tails of the ladder
    // using the secure random class with boundaries so that overlapping
    // of heads positions and tails positions is very low in their respective boundaries.
    public Ladder(int a){
        SecureRandom rand = new SecureRandom();
        ladder_beginnings=new int[a+1];
        ladder_endings=new int[a+1];


        //here we are assigning ladder beginning points and ending points.condition is there should be no
        //ladder_beginnings assigned at same place so after assigning we will check the array and if
        //assigned same position we will redirect random function again
        //ladder beginning is between 1 and 50 and  ladder  endings are between 50 and 90

        for(int i=1;i<=a;i++){
            ladder_beginnings[i]=rand.nextInt(45)+1;
        }
        for(int i=1;i<=a;i++){
            ladder_endings[i]=rand.nextInt(40)+50;
        }

    }

    // methods that return ladder heads and tails respectively which are generated randomly
    public int[] returnArray_beginnings(){
        return ladder_beginnings;
    }
    public int[] returnArray_endings(){
        return ladder_endings;
    }
}