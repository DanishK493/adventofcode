import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

    public static void main(String[] args) {
        try {
            String filePath = "input.txt";
            int sum = calculateSum(filePath);
            System.out.println("Sum of calibration values: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateSum(String filePath) throws IOException {
        int sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int value = extractCalibrationValue(line);
                sum += value;
            }
        }

        return sum;
    }

    private static int extractCalibrationValue(String line) {
        char firstDigit = ' ';
        char lastDigit = ' ';

        for (char ch : line.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (firstDigit == ' ') {
                    firstDigit = ch;
                }
                lastDigit = ch;
            }
        }
        int value = Integer.parseInt("" + firstDigit + lastDigit);
        return value;
    }
}