import java.util.Scanner;
import java.util.Random;
public class sevenUp {
    public static void main(String[] args)
    {
        int gue;
        int tot = 0;
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        System.out.println("7 up ");
        System.out.printf("Enter your guess \n 1.Down \n 2.Up \n 3.Exact 7 : ");
        gue = s.nextInt();
        for(int i = 0 ;i < 2;i++)
        {
            int roll = r.nextInt(1,7);
            die(roll);
            tot += roll;
        }
        if(tot < 7 && gue == 1)
        {
            System.out.println("Correct");
        }
        else if(tot > 7 && gue == 2)
        {
            System.out.println("Correct");
        }
        else if(tot == 7 && gue == 3)
        {
            System.out.println("Amazingg!");
        }
        else {
            System.out.println("Try again!");
        }



    }
    static void die(int roll)
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
