package Day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static char findSameItem(String line) {

        LinkedList<Character> itesmsFromLeft = new LinkedList<>();
        LinkedList<Character> itesmsfromRight = new LinkedList<>();
        Set<Character> result = new HashSet<>();

        for(int i=0;i<line.length()/2;i++) {
            itesmsFromLeft.add(line.charAt(i));
            itesmsfromRight.add(line.charAt(line.length()-1-i));
        }

        for(Character item: itesmsFromLeft) {
            if(itesmsfromRight.contains(item)){
                result.add(item);
            }
        }
        return result.toString().substring(1, 2).charAt(0);
    }

    public static int getPoints(char element) {
        int valueToSubstractForLowerCase = 96;
        int valueToSubstractForUpperCase = 38;

        if(((int) element) < 97) {
            return (int) element - valueToSubstractForUpperCase;
        } else {
            return (int) element - valueToSubstractForLowerCase;
        }
    }

    public static void main(String[] args) {

        File input = new File("Day_3/input.txt");
        int points = 0;

        try {
            Scanner in = new Scanner(input);

            while (in.hasNextLine()) {
                points += getPoints(findSameItem(in.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.println(points);
    }
}
