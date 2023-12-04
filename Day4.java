import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Day4 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            String[] lines = new String[218];
            int currentLineIndex = 0;

            while ((line = br.readLine()) != null) {
                lines[currentLineIndex++] = line;
            }

            int p1 = 0;

            for (int i = 0; i < currentLineIndex; i++) {
                line = lines[i];
                Set<Integer> winning = new HashSet<>();
                String[] parts = line.split(":")[1].split("\\|");
                String[] winningNumbers = parts[0].trim().split("\\s+");
                String[] haveNumbers = parts[1].trim().split("\\s+");

                for (String num : winningNumbers) {
                    winning.add(Integer.parseInt(num));
                }

                Set<Integer> have = new HashSet<>();
                for (String num : haveNumbers) {
                    int x = Integer.parseInt(num);
                    if (winning.contains(x)) {
                        have.add(x);
                    }
                }

                if (have.size() > 0) {
                    p1 += Math.pow(2, have.size() - 1);
                }

            }
            System.out.println(p1);
            br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
