package Day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File input = new File("Day_2/input.txt"); //Input file

        final int ROCK = 1, PAPER = 2, SCISSORS = 3;//Points for using specific sign
        final int LOSE = 0, DRAW = 3, WIN = 6;//Points for game outcome
        int sumStrat1 = 0, sumStrat2 = 0;//Variables to sum points for each strategy

        //HashMaps contain key: all possible combinations of input, value: points according to a specific strategy
        Map<String, Integer> strategy1 = new HashMap<>();
        Map<String, Integer> strategy2 = new HashMap<>();

        //A, B, C - competitor's choice; X, Y, Z - my choice
        strategy1.put("A X", ROCK + DRAW);          //A, X -> Rock
        strategy1.put("A Y", PAPER + WIN);          //B, Y -> Paper
        strategy1.put("A Z", SCISSORS + LOSE);      //C, Z -> Scissors
        strategy1.put("B X", ROCK + LOSE);
        strategy1.put("B Y", PAPER + DRAW);
        strategy1.put("B Z", SCISSORS + WIN);
        strategy1.put("C X", ROCK + WIN);
        strategy1.put("C Y", PAPER + LOSE);
        strategy1.put("C Z", SCISSORS + DRAW);

        //A, B, C - competitor's choice; X, Y, Z - expected outcome of the game
        strategy2.put("A X", SCISSORS + LOSE);      //A -> Rock
        strategy2.put("A Y", ROCK + DRAW);          //B -> Paper
        strategy2.put("A Z", PAPER + WIN);          //C -> Scissors
        strategy2.put("B X", ROCK + LOSE);
        strategy2.put("B Y", PAPER + DRAW);         //X -> lose
        strategy2.put("B Z", SCISSORS + WIN);       //Y -> draw
        strategy2.put("C X", PAPER + LOSE);         //Z -> win
        strategy2.put("C Y", SCISSORS + DRAW);
        strategy2.put("C Z", ROCK + WIN);

        try {
            Scanner in = new Scanner(input);

            while (in.hasNextLine()) {
                String line = in.nextLine();

                //Summing up points
                sumStrat1 += strategy1.get(line);
                sumStrat2 += strategy2.get(line);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        //Printing results
        System.out.println("Points from strategy 1: "+sumStrat1);
        System.out.println("Points from strategy 2: "+sumStrat2);
    }
}
