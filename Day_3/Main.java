package Day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static LinkedList<Character> stringToArrayList(String str) {
        LinkedList<Character> results = new LinkedList<>();
        for(char element: str.toCharArray()) {
            results.add(element);
        }
        return results;
    }

    public static char findSameItem(String line1, String line2, String line3) {

        LinkedList<Character> items1 = stringToArrayList(line1);
        LinkedList<Character> items2 = stringToArrayList(line2);
        Set<Character> result = new HashSet<>();

        if(!line3.equals("")) {
            LinkedList<Character> items3 = stringToArrayList(line3);
            for(Character element: items1) {
                if(items2.contains(element) && items3.contains(element)) {
                    result.add(element);
                }
            }

        }else {
            for(Character element: items1) {
                if(items2.contains(element)) {
                    result.add(element);
                }
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

        String[] lines = new String[3];
        int counter = 0;
        int points2 = 0;

        try {
            Scanner in = new Scanner(input);
            String line;
            while (in.hasNextLine()) {
                line = in.nextLine();
                points += getPoints(findSameItem(line.substring(0, (line.length()/2)), line.substring(line.length()/2), ""));

                if(counter<3) {
                    lines[counter] = line;
                    counter++;
                }

                if(counter == 3) {
                    points2 += getPoints(findSameItem(lines[0], lines[1], lines[2]));
                    counter = 0;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.println(points);
        System.out.println(points2);
    }
}
