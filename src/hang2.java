import java.util.Arrays;
import java.util.Scanner;

public class hang2 {
    public static void main (String[]args){

        //setup for testword *******************************************************************************
        String testword = "dog";
        int testwordlength = testword.length();
        char[] testwordarray = new char[testwordlength]; //{'d','o','g'}
        //fill array with the strings chars
        for(int a = 0; a<testwordlength; a++){
            testwordarray[a] = testword.charAt(a);
        }
        //setup for answerarray ***************************************************************************
        char[] answerarray = new char[testwordlength]; //the array thatll hold the user input
        //fill answer array with '*' thatll be swapped out each time they hit a right char
        for(int a = 0; a<testwordlength; a++){
            answerarray[a] = '*';
        }

        //game win/lose conditions**************************************************************************
        boolean iswon = false;
        int tries = 5; int triesused = 0;
        int count = 0;


        System.out.println("HANGMAN guess my word, it is " + testwordlength + " letters long");
        System.out.println("After " + tries + " mistakes you lose");

        //***********COULD BE MOVED TO ANOTHER METHOD******************************************************
        //***********************************************************************************************
        while(iswon == false || triesused != (tries+1)){
            //loop out when they either won, or their tries are used up
            System.out.println("put in your next guess");
            Scanner scanthing = new Scanner(System.in);
            char userinput = scanthing.next().charAt(0);


            for(int i =0; i<testwordlength; i++){
                if(userinput == testwordarray[i]){
                    answerarray[i] = testwordarray[i];
                    System.out.println(answerarray); //show current progress
                    count = 1;
                }
            }

            if(Arrays.equals(answerarray, testwordarray)){
                iswon = true;
            }

            if(count == 1){
                triesused--;
            }

            count = 0;
            triesused++;
        }


        //outside the of while loop**************************************************
    }
}
