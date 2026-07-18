import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        Random rand= new Random();
        int score =0;
        String choice="yes";
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I will think of a number between 1 and 100 and you have to guess the correct one");
        while (choice.equalsIgnoreCase("yes")){
            int target =rand.nextInt(100) + 1;
            int attempts= 0;
            int maxTries= 7;
            boolean won =false;
            System.out.println("\nNew round started. You have " + maxTries + " tries.");
            while(attempts<maxTries){
                System.out.print("Enter your guess: ");
                if(!sc.hasNextInt()){
                    System.out.println("That's not a number, try again.");
                    sc.next();
                    continue;
                }
                int guess=sc.nextInt();
                attempts++;
                if(guess==target){
                    won=true;
                    break;
                } 
                else if(guess>target){
                    System.out.println("This number is too high! Guess again.");
                } 
                else{
                    System.out.println("This number is too low! Guess again.");
                }
                System.out.println("Tries left: " + (maxTries-attempts));
            }
            if(won){
                int pointsEarned=(maxTries-attempts+1)*10;
                score+=pointsEarned;
                System.out.println("You got it!The number was " + target);
                System.out.println("Attempts used: " + attempts + "  Points earned: " + pointsEarned);
            } 
            else{
                System.out.println("No more tries left.The number was " + target);
            }
            System.out.println("Total score: " + score);
            System.out.print("\nPlay another round? (yes/no): ");
            choice= sc.next();
        }
        System.out.println("\nThanks for playing! Final score: " + score);
        sc.close();
    }
}
