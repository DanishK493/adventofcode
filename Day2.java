import java.util.*;
import java.io.*;

class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        int maxred = 12;
        int maxgreen = 13;
        int maxblue = 14;
        int id = 0;
        int sumofpower = 0;
        while (scanner.hasNextLine()) {
            int red = 0;
            int green = 0;
            int blue = 0;
            String line = scanner.nextLine();
            String sets = line.split(": ")[1];
            for (String set : sets.split("; ")) {
                String[] rgb = set.split(", ");
                for (String color : rgb) {
                    int space = color.indexOf(" ");
                    int colornumber = Integer.parseInt(color.substring(0, space));
                    if (color.contains("red")) {
                        if (colornumber > red) {
                            red = colornumber;
                        }
                    } else if (color.contains("green")) {
                        if (colornumber > green) {
                            green = colornumber;
                        }
                    } else if (color.contains("blue")) {
                        if (colornumber > blue) {
                            blue = colornumber;
                        }
                    }
                        
                }
            }
            if (red <= maxred && green <= maxgreen && blue <= maxblue)
                list.add(id + 1);
            sumofpower += (red * green * blue);
            id++;
        }
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        scanner.close();
        System.out.println("Part 1: " + sum + " Part 2: " + sumofpower);
    }
}

