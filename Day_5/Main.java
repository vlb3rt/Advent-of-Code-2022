package Day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    //HashMaps used to store locations of all containers for each stratyegy
    static HashMap<Integer, String> oneByOne = new HashMap<>();
    static HashMap<Integer, String> allAtOnce = new HashMap<>();

    //Function used to print top elements of each index
    public static String printTops(HashMap<Integer, String> containers) {
        String tops = "";
        for(int i=0;i<containers.size();i++) tops += containers.get(i).charAt(containers.get(i).length()-1);
        return tops;
    }

    //Function used to turn file input into a HashMap<Integer, String>
    public static void positionsToHashMap(String line, HashMap<Integer, String> containers) {
        int index = 0;
        String value;
        for(Character lineChar : line.toCharArray()) {
            if(index % 4 == 1 && !lineChar.toString().equals(" ")) {
                if(containers.get(index / 4) == null)  value = Character.toString(lineChar);
                else  value = lineChar + containers.get(index / 4);
                containers.put(index / 4, value);
            }
            index++;
        }
    }

    //Strategy 1 - elements are being moved one by one
    public static void moveOneByOne(Integer[] vector, HashMap<Integer, String>containers) {
        String begining;
        for(int i=0;i<vector[0];i++) {
            begining = containers.get( vector[1]);
            containers.put(vector[1], begining.substring(0, begining.length()-1));
            containers.put(vector[2], containers.get(vector[2]) + begining.charAt(begining.length()-1));
        }
    }

    //Strategy 2 - alements are being moved all at once
    public static void moveAllAtOnce(Integer[] vector, HashMap<Integer, String> containers) {
        String begining;
        begining = containers.get(vector[1]);
        containers.put(vector[1], begining.substring(0, begining.length() - vector[0]));
        containers.put(vector[2], containers.get(vector[2]) + begining.substring((begining.length() - vector[0])));
    }

    //Function turning file input into a move vector
    public static void move(String line) {
        Integer[] vector = new Integer[3];
        if(Character.toString(line.charAt(6)).equals(" ")) {
            vector[0] = Integer.parseInt(line.substring(5,6));
            vector[1] = Integer.parseInt(line.substring(12,13)) - 1;
            vector[2] = Integer.parseInt(line.substring(17)) - 1;
        }else {
            vector[0] = Integer.parseInt(line.substring(5,7));
            vector[1] = Integer.parseInt(line.substring(13,14)) - 1;
            vector[2] = Integer.parseInt(line.substring(18)) - 1;
        }
        moveOneByOne(vector, oneByOne);
        moveAllAtOnce(vector, allAtOnce);
    }

    public static void main(String[] args) {

        File input = new File("Day_5/input.txt");

        try {
            Scanner in = new Scanner(input);
            String line;//Variable used to store each line of input file
            int lineCounter = 0;//Variable used to count each line of input file

            while (in.hasNextLine()) {
                line = in.nextLine();

                if (lineCounter < 8) {
                    positionsToHashMap(line, oneByOne);
                    positionsToHashMap(line, allAtOnce);
                } else if (lineCounter > 9) move(line);

                lineCounter++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Printing results
        System.out.println("One By One: " + printTops(oneByOne));
        System.out.println("All At Once: " + printTops(allAtOnce));
    }
}
