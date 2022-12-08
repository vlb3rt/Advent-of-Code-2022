package Day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File input = new File("Day_1/input.txt");

        //ArrayList contains sum of calories for each elf
        ArrayList<Integer> elves = new ArrayList<>();

        int sumCal = 0; //Used to sum calories carried by one elf
        final int TOP_ELVES = 3; //Defines how many elves are counted in 2nd part
        int topSum = 0; //Used to sum calories caried by top elves

        try {
            Scanner in = new Scanner(input);
            String line; //Variable used to store each line of input file

            while (in.hasNextLine()) {
                line = in.nextLine();

                //Conditions summing and adding calories to the ArrayList for each elf
                if (line.equals("")) {
                    elves.add(sumCal);
                    sumCal = 0;
                }else {
                    sumCal += Integer.parseInt(line);
                }
            }
            in.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        //Sorting ArrayList
        Collections.sort(elves);

        //Summing tom elves calories
        for(int i=1;i<=TOP_ELVES;i++) {
            topSum += elves.get(elves.size()-i);
        }

        //Printing results
        System.out.println("Top 1 cal: "+elves.get(elves.size()-1));
        System.out.println("Top "+TOP_ELVES+" cal sum: "+topSum);
    }
}
