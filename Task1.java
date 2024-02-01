





package package123;
import java.util.Random;
import java.util.Scanner;

public class Task1{
    public static void main(String args[])
    {
        // create instance of Random class
        Random rand = new Random();
        // Generate random integers in range 0 to 99
        int rand_int = rand.nextInt(100);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers to find the random one");
        int num=0;
        int count=0;
        boolean playAgain=true;
        while(playAgain ) {
            while(count<5){
            if (num == rand_int) {
                System.out.println("You find out random number in first guess");
            }
            else {
                while (num != rand_int) {
                    num = sc.nextInt();
                    if (rand_int > num) {
                        System.out.println("Number is Greater than your number");
                    } else if (rand_int < num) {
                        System.out.println("Number is Less than your number");
                    } else {
                        System.out.println("Number is Equal to Your Number.....");
                    }
                    count++;
                }
                System.out.println("Your score is: "+count);
            }
        }
            System.out.println("Do you want to play again?(Yes/No)");
            String playChoice = sc.next();
            if(playChoice.equalsIgnoreCase("no")){
                playAgain=false;
            }
            if(!playChoice.equalsIgnoreCase("yes")){
                playAgain=true;
            }
        }
        sc.close();
    }
}
