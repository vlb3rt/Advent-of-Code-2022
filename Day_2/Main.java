package Day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File input = new File("Day_2/input.txt");

        final int rock = 1, paper = 2, scissors = 3;
        final int lose = 0, draw = 3, win = 6;

        //HashMaps contain key: all possible combinations of input, value: points according to a specific strategy
        Map<String, Integer> strategy1 = new HashMap<>();
        Map<String, Integer> strategy2 = new HashMap<>();

        //A, B, C - competitor's choice; X, Y, Z - my choice
        strategy1.put("A X", rock + draw);          //A, X -> Rock
        strategy1.put("A Y", paper + win);          //B, Y -> Paper
        strategy1.put("A Z", scissors + lose);      //C, Z -> Scissors
        strategy1.put("B X", rock + lose);
        strategy1.put("B Y", paper + draw);
        strategy1.put("B Z", scissors + win);
        strategy1.put("C X", rock + win);
        strategy1.put("C Y", paper + lose);
        strategy1.put("C Z", scissors + draw);

        //A, B, C - competitor's choice; X, Y, Z - expected outcome of the game
        strategy2.put("A X", scissors + lose);      //A -> Rock
        strategy2.put("A Y", rock + draw);          //B -> Paper
        strategy2.put("A Z", paper + win);          //C -> Scissors
        strategy2.put("B X", rock + lose);
        strategy2.put("B Y", paper + draw);         //X -> lose
        strategy2.put("B Z", scissors + win);       //Y -> draw
        strategy2.put("C X", paper + lose);         //Z -> win
        strategy2.put("C Y", scissors + draw);
        strategy2.put("C Z", rock + win);

        try {
            Scanner in = new Scanner(input);
            int sum1 = 0;
            int sum2 = 0;
            while (in.hasNextLine()) {
                String line = in.nextLine();

                sum1 += strategy1.get(line);
                sum2 += strategy2.get(line);
            }
            System.out.println("Points from strategy 1: "+sum1);
            System.out.println("Points from strategy 2: "+sum2);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
