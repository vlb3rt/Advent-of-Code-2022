package Day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File input = new File("Day_1/input.txt");
        ArrayList<Integer> elves = new ArrayList<>();

        int topElves = 3, topSum = 0;
        int sumCal = 0;

        try {
            Scanner in = new Scanner(input);
            String lineAsString;

            while (in.hasNextLine()) {
                lineAsString = in.nextLine();

                if(lineAsString.equals("")) {
                    elves.add(sumCal);
                    sumCal = 0;
                }else {
                    sumCal += Integer.parseInt(lineAsString);
                }
            }
            Collections.sort(elves);
            System.out.println("Top 1 cal: "+elves.get(elves.size()-1));

            for(int i=1;i<=topElves;i++) {
                topSum += elves.get(elves.size()-i);
            }

            System.out.println("Top "+topElves+" cal sum: "+topSum);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
