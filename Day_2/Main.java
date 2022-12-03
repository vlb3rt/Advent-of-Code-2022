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

        Map<String, Integer> results = new HashMap<>();
        results.put("A X", rock + draw);
        results.put("A Y", paper + win);
        results.put("A Z", scissors + lose);
        results.put("B X", rock + lose);
        results.put("B Y", paper + draw);
        results.put("B Z", scissors + win);
        results.put("C X", rock + win);
        results.put("C Y", paper + lose);
        results.put("C Z", scissors + draw);

        try {
            Scanner in = new Scanner(input);
            int sum = 0;
            while (in.hasNextLine()) {
                Integer currentPoint = results.get(in.nextLine());
                sum += currentPoint;
            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
