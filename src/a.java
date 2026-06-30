import java.util.Scanner;
import java.util.Random;
public class a {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int noOfDice;
        int total = 0;
        System.out.println("Enter the no of dice to roll");
        noOfDice = s.nextInt();
        if(noOfDice > 0)
        {
            for(int i = 0; i < noOfDice ;i++){
                int roll = r.nextInt(1 ,7);
                printDie(roll);
                System.out.println("You Rolled " + roll);
                total += roll;
            }
            System.out.println("Total : "+total);
        }
        else
        {
            System.out.println("No of dice must be greater than zero");
        }
    }
    static void printDie(int roll)
    {
        String dice1 = """
            -------
           |       |
           |   ●   |
           |       |
            -------
            """;
        String dice3 = """
            -------
           | ●     |
           |   ●   |
           |     ● |
            -------
                """;
        String dice2 = """
            -------
           | ●     |
           |       |
           |     ● |
            -------
                
                
                """;
        String dice4 = """
            -------
           | ●   ● |
           |       |
           | ●   ● |
            -------
                """;
        String dice5 = """
            -------
           | ●   ● |
           |   ●   |
           | ●   ● |
            -------     
                """;
        String dice6 = """
            -------
           | ●   ● |
           | ●   ● |
           | ●   ● |
            -------     
                """;
        switch(roll)
        {
            case 1 -> System.out.print(dice1);
            case 2 -> System.out.print(dice2);
            case 3 -> System.out.print(dice3);
            case 4 -> System.out.print(dice4);
            case 5 -> System.out.print(dice5);
            case 6 -> System.out.print(dice6);
            default ->
                System.out.println("Invalid");

        }
    }
}
