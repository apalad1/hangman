import java.util.*;
public class hangmangame {
    public static void main(String[]args){

        int tries = 6;
        String myword = "poop";
        int lengthofword = myword.length();


        System.out.println("HANGMAN guess my word, it is " + lengthofword + " letters long");
        System.out.println("After " + tries + " mistakes you lose");

       //convert myword to array + have an answerarray with the same length
        char[] mywordarray = new char[lengthofword]; //the array that holds the myword string
        char[] answerarray = new char[lengthofword]; //the array that you fill in with correct answers
        char[] correctanswers = new char[lengthofword]; //the array of answers you got right, this is to account for repeats

        //fill the mywordarray with the chars of string myword
        for(int a = 0; a<lengthofword; a++){
            mywordarray[a] = myword.charAt(a);

        }
        //print * equal to the words length
        System.out.println("My word is a " + lengthofword + " letter long word");


        //fill answer array with '*' thatll be swapped out each time they hit a right char
        for(int a = 0; a<lengthofword; a++){
            answerarray[a] = '*';

        }

        //hangman visual
        char[] lose = {'d', 'e', 'a', 't', 'h'};
        //the array thatll display when you fail an attempt the previous letters you tried, same length as the amount of tries
        char[] thefailedtriedchars = new char[tries];


        while(tries>0) { //you get 5 tries each time it goes down
                System.out.println("put in your next guess");
                Scanner scanthing = new Scanner(System.in);
                char userinput = scanthing.next().charAt(0);
                boolean isright = false;

            //check for match loop
            for(int b = 0; b<lengthofword; b++){
                if(userinput == mywordarray[b]){ //finding a match
                    answerarray[b] = mywordarray[b];
                    correctanswers[b] = mywordarray[b];
                    System.out.println(answerarray); //show current progress

                    if(Arrays.equals(answerarray, mywordarray)){ //if the array contents are exactly the same you win and tries is set to 0 to exit
                        System.out.println("You win!");
                        tries = 0;
                    }
                    isright = true;


                }

            }
            if(isright == false){
                tries--;
                System.out.println("Careful, you have " + tries + " tries left.");
                picture(tries);
            }


        }


        
    }

    public static void picture(int tries){
        switch (tries){
            case 5:

                System.out.println("..O");
                break;
            case 4:
                System.out.println("..O");
                System.out.println("..1");
                break;
            case 3:
                System.out.println("..O");
                System.out.println("..1");
                System.out.println("./");
                break;
            case 2:
                System.out.println("..O");
                System.out.println("..1");
                System.out.println("./.L");
                break;
            case 1:
                System.out.println("..O");
                System.out.println("--1");
                System.out.println("./.L");
                break;
            case 0:
                System.out.println("..O");
                System.out.println("--1--");
                System.out.println("./.L");
                System.out.println("gg");
                break;
            default:
                System.out.println(".");
                break;
        }
    }
}
