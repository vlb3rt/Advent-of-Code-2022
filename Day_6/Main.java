package Day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    //Function used to check whether all elements are different
    public static boolean isMarker(LinkedList<Character> marker, int markerSize) {
        int occurance = 0;
        for(Character element : marker) {
            for(Character x : marker) {
                if(element.equals(x)) occurance++;
            }
        }
        return occurance == markerSize;
    }

    //function used to loop through the line input
    public static int loop(String line, int markerSize) {
        int lineSize = line.length();
        LinkedList<Character> marker = new LinkedList<>();
        for(int i=0;i<lineSize-markerSize;i++) {
            marker.add(line.charAt(i));
            if(i>=markerSize-1) {
                if(isMarker(marker, markerSize)) {
                    return i+1;
                }else {
                    marker.remove(0);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        File file = new File("Day_6/input.txt");
        String line;
        try {
            Scanner in = new Scanner(file);
            line = in.nextLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("First marker for length 4: "+loop(line, 4));
        System.out.println("First marker for length 14: "+loop(line, 14));
    }
}
