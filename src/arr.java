import java.util.Scanner;

public class arr {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] q = {"What was the first prpgramming language?",
                     "Who is the father of computer?",
                     "What is considered as the brain of a computer?"};
        String[][] op = {{"1.C","2.Fortran","3.Assembly","4.COBOL"},
                         {"1.Steve Jobs","2.Adolf Hitler","3.Charles Babbage","4.Bill Gates"},
                         {"1.GPU","2.CPU","3.Hard drive","4.RAM"}};
        int[] ans = {2,3,2};
        int score = 0;
        int guess;
        System.out.println("*********");
        System.out.println("Quiz");
        System.out.println("*********");
        for(int i = 0;i < q.length ;i++){
            System.out.println(q[i]);

            for(String option :op[i]){
                System.out.println(option);
            }
            System.out.print("Enter your guess:  ");
            guess = s.nextInt();
            if(guess == ans[i]){
                System.out.println("Correct answer");
                score++;
            }
            else{
                System.out.println("Wrong answer");
            }
        }
        System.out.println("Quiz ended and your score is "+score+"/"+q.length);
    }
}
