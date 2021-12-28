import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.ArrayList;
import java.util.Scanner;

public class Lotto {


    public static void main(String[] args) {
        System.out.println("Enter you lucky numbers 6th number being bonus from 1 to 23");
        int[] luckyNumbers = playerNumbers();
        int[] winningNumbers = pullNumbers();
        display(winningNumbers,luckyNumbers);
        determineWin(luckyNumbers, winningNumbers);



    }

    public static int[] pullNumbers(){//generate random draw numbers from 1 - 52

        int[] pullNumbers = new int[6];
        int temp = 0;



       
        pullNumbers[5] = (int)(Math.random()*2)+1;
        return pullNumbers;
    }

    public static int[]playerNumbers(){
        Scanner in = new Scanner(System.in);
        int[] playerNumbers = new int[6];
        for(int i = 0; i< playerNumbers.length;i++){
            playerNumbers[i] = in.nextInt();
        }
        return playerNumbers;
    }

    public static void display(int[] winningNumbers, int[] luckyNumbers){
        System.out.println("Winning numbers are :");
        for (int i = 0; i<winningNumbers.length-1; i++) {
            System.out.print(" " + winningNumbers[i]);

        }
        System.out.println(" bonus " +winningNumbers[5] +"\n--------------------------------------------------------------------\n");

        System.out.println("Your lucky numbers are : ");
        for (int i =0; i< luckyNumbers.length-1; i++){
            System.out.print(" "+luckyNumbers[i]);
        }
        System.out.println(" bonus " +luckyNumbers[5] +"\n--------------------------------------------------------------------\n");

    }

    public static void determineWin(int[] luckyNumbers, int[] winningNumbers){
        ArrayList<Integer> matches = new ArrayList();
        int count =0;
        int bonus = 0;

        for(int i = 0; i<5;i++){
            for(int j = 0; j<5;j++){
            if(luckyNumbers[i]== winningNumbers[j]){

                matches.add(winningNumbers[j]);
                count++;
            }
            }
            if (luckyNumbers[5]==winningNumbers[5]){
                bonus = winningNumbers[5];
            }
        }

        switch (count){
            case 0:
                System.out.println("no matches");
                break;
            case 1:
                System.out.println("1 match better luck next time");
                System.out.println(matches.toString().replace("[","").replace("]"," "));

                break;

            case 2:
                if(bonus>0){
                    System.out.println("2 numbers plus bonus winner!! ");
                    System.out.println(matches.toString().replace("[","").replace("]"," "));
                    System.out.println("bonus "+bonus);

                }
                else{
                System.out.println("2 numbers try again");
                System.out.println(matches.toString().replace("[","").replace("]"," "));}

                break;
            case 3:
                System.out.println("3 numbers WINNER!!");
                System.out.println(matches.toString().replace("[","").replace("]"," "));
                if(bonus>0)
                    System.out.println("plus bonus "+bonus);
                break;
            case 4:
                System.out.println("4 numbers WINNER!!");
                System.out.println(matches.toString().replace("[","").replace("]"," "));
                if(bonus>0)
                    System.out.println("plus bonus "+bonus);
                break;
            case 5:
                System.out.println("5 numbers JACKPOT WINNER!!");
                System.out.println(matches.toString().replace("[","").replace("]"," "));
                if(bonus>0)
                    System.out.println("plus bonus "+bonus);
                break;

        }


    }
}


