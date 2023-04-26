package game;
import java.util.Random;
import java.util.Scanner;
public class OneUser{
    //Needed data types:
    private int userScore;
    private int systemScore;
    private String userChoice;
    private String systemChoice;
    private String username;
    private String[] words = {"rock","paper","scissors"};
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Constructor that automatically runs the game:
    public OneUser(){
            userScore = 0;
            systemScore = 0;
            oneUserPlay();
    }//end of constructor
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // One User mode:
    private void oneUserPlay(){
        Scanner input = new Scanner(System.in);
        System.out.println("HELLO AND WELCOME TO THE GAME!");
        System.out.print("Enter your name: ");
        username = input.next();
        System.out.printf("Hey %s, are you ready? [yes/no]%n",username);
        String answer = input.next();
        if((answer.toLowerCase()).equals("yes")){
            System.out.println();
            while(true){
                System.out.println("It's your turn, play!");
                String Choice = input.next();
                userChoice = Choice.toLowerCase();
                if(!(userChoice.equals("rock")) & !(userChoice.equals("paper")) & !(userChoice.equals("scissors"))){
                    System.out.println("Wrong answer.");
                }else{
                    systemPlay();
                    System.out.println("System Choice: "+systemChoice+"\n");
                    oneUserCheck(userChoice,systemChoice);
                }
                if(userScore == 5){
                    System.err.println("\n\n---------------------------------\nCongratulations!!!\nYou won!\n---------------------------------");
                    break;
                } else if (systemScore == 5) {
                    System.err.println("\n\n---------------------------------\nOoh no!!!\nYou lost!\n---------------------------------");
                    break;
                }
                System.out.println("---------------------------------");
            }
        }else {
            System.out.println("...GOODBYE...");
        }
    }//end of oneUserPlay
    private void systemPlay(){
        Random rnd = new Random();
        int x = rnd.nextInt(3);
        systemChoice = words[x];
    }//end of systemPlay
    private void oneUserCheck(String user, String system){
        if(user.equals("rock") && system.equals("paper")){
            systemScore++;
            System.out.printf("Oops...%nSystem Score: %d\tYour Score:%d%n",systemScore,userScore);
        }else if(user.equals("rock") && system.equals("scissors")){
            userScore++;
            System.out.printf("Great!%nSystem Score: %d\tYour Score:%d%n",systemScore,userScore);
        }if(user.equals("paper") && system.equals("rock")){
            userScore++;
            System.out.printf("Great!%nSystem Score: %d\tYour Score:%d%n",systemScore,userScore);
        }if(user.equals("paper") && system.equals("scissors")){
            systemScore++;
            System.out.printf("Oops...%nSystem Score: %d\tYour Score:%d%n",systemScore,userScore);
        }if(user.equals("scissors") && system.equals("rock")){
            systemScore++;
            System.out.printf("Oops...%nSystem Score: %d\tYour Score:%d%n",systemScore,userScore);
        }if(user.equals("scissors") && system.equals("paper")){
            userScore++;
            System.out.printf("Great!%nSystem Score: %d\tYour Score:%d%n",systemScore,userScore);
        }if(user.equals(system)){
            System.out.printf("Equal...%nSystem Score: %d\tYour Score:%d%n",systemScore,userScore);
        }
    }//end of oneUserCheck
}
