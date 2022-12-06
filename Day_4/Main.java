package Day_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //Function checks whether one range fully overlaps second
    public static boolean fullCover(ArrayList<Integer> range) {
        if(range.get(0) <= range.get(2) && range.get(1) >= range.get(3)) return true;
        if(range.get(2) <= range.get(0) && range.get(3) >= range.get(1)) return true;
        return false;
    }

    //Function checks whether one range partially overlaps second
    public static boolean partCover(ArrayList<Integer> range) {
        if(range.get(2) <= range.get(1) && range.get(3) >= range.get(0)) return true;
        return false;
    }

    //Function turns string into ArrayListy of type Integer
    public static ArrayList<Integer> lineToRangeList(String line) {
        line = line.replace(',', '-');
        List<String> rangeAsString = List.of(line.split("-"));

        ArrayList<Integer> range = new ArrayList<>();
        for(String border: rangeAsString) {
            range.add(Integer.parseInt(border));
        }
        return range;
    }

    public static void main(String[] args) {

        File input = new File("Day_4/input.txt");
        int counter1 = 0;
        int counter2 = 0;
        try {
            Scanner in = new Scanner(input);
            String line;

            while (in.hasNextLine()) {
                line = in.nextLine();
                if(fullCover(lineToRangeList(line))){
                    counter1++;
                }
                if(partCover(lineToRangeList(line))){
                    counter2++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Printing results
        System.out.println("Full overlaps: "+counter1);
        System.out.println("Partial overlaps: "+counter2);
    }
}
