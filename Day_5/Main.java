package Day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<Integer, String> containers = new HashMap<>();

    public static void printTops() {
        String tops = "";
        for(int i=0;i<containers.size();i++) {
            tops += containers.get(i).charAt(containers.get(i).length()-1);
        }
        System.out.println(tops);
    }

    public static void positionsToHashMap(String line) {
        int index = 0;
        String value;
        for(Character lineChar : line.toCharArray()) {
            if(index % 4 == 1 && !lineChar.toString().equals(" ")) {
                if(containers.get(index / 4) == null) {
                    value = Character.toString(lineChar);
                } else {
                    value = lineChar + containers.get(index / 4);
                }
                containers.put(index / 4, value);
            }
            index++;
        }
    }

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
        System.out.println(vector[0]+" "+(vector[1]+1)+" "+(vector[2]+1));

        String value, begining, end;

        for(int i=0;i<vector[0];i++) {
            begining = containers.get(vector[1]);
            containers.put(vector[1], begining.substring(0, begining.length()-1));
            value = String.valueOf(begining.charAt(begining.length()-1));

            end = containers.get(vector[2]) + value;
            containers.put(vector[2], end);
        }
    }

    public static void main(String[] args) {

        File input = new File("Day_5/input.txt");

        try {
            Scanner in = new Scanner(input);
            String line;
            int lineCounter = 0;
            while (in.hasNextLine()) {
                line = in.nextLine();

                if(lineCounter < 8) positionsToHashMap(line);
                else if (lineCounter > 9) move(line);

                lineCounter++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        printTops();
    }

}
