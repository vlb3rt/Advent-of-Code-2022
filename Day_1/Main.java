package Day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File input = new File("Day_1/input.txt");

        try {
            Scanner in = new Scanner(input);
            String lineAsString;
            int maxCal = 0, maxPerson = 0;
            int sumCal = 0, person = 0;

            while (in.hasNextLine()) {
                lineAsString = in.nextLine();

                if(lineAsString.equals("")) {
                    if(sumCal > maxCal) {
                        maxCal = sumCal;
                        maxPerson = person;
                    }
                    sumCal = 0;
                    person++;
                }else {
                    sumCal += Integer.parseInt(lineAsString);
                }
            }
            System.out.println(maxPerson);
            System.out.println(maxCal);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
