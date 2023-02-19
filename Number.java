import java.util.*;
public class Number {
	static ArrayList<Integer> score = new ArrayList<Integer>(); //Array list
    public static void main(String[] args) //Main method
    {
     Number method = new Number();
        method.menu(score);
    }
    public void menu(ArrayList<Integer> scoreBoard) //Method created for menu of number guessing game
    {
     Number method = new Number(); //Constructor
        Scanner sc = new Scanner(System.in); //Scanner class object is created
        System.out.println("--------------------");
        System.out.println("Welcome to the number game");
        System.out.println("1 --> Play the Game");
        System.out.println("2 --> Score");
        System.out.println("3 --> Close the game");
        System.out.println("--------------------");
        try //Try block for exception handling
        {
            System.out.println("Which action would you like to perform?? ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Range of number in which you like to play the game?? ");
                    int numberRange = sc.nextInt();
                    int randomNumber = method.randomNumber(numberRange);
                    method.guessNumber(randomNumber);
                    break;
                case 2:
                    method.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("You entered invalid try.Would you like to play this game again?? ");
            }
        }
        catch(InputMismatchException e)//Catch block for exception handling
        {
            System.err.println(e.getMessage());
            menu(scoreBoard);
        }
    }
    public int randomNumber(int numberRange) //Method created to get number range as an input from user
    {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) //Method created to compare a random number and number given by user as an input
    {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        score.add(guess);
        System.out.println(" ");

        menu(score);
    }
    public void displayScoreBoard() //Method created to display the scoreboard to user as an output
    {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        System.out.println("Your fastest games today out of all tries is: ");
        Collections.sort(score);
        for (Integer scores : score)
        {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(score);
    }
}
