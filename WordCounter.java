import java.io.*;
import java.util.*;

public class WordCounter {

    public static void main(String[] args) {
        // Check if input and output file names are provided as command-line arguments
        if (args.length < 2) {
            System.out.println("Usage: java WordCounter <input_file> <output_file>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        // Use a TreeMap to store words and their counts (TreeMap maintains alphabetical order)
        Map<String, Integer> wordCounts = new TreeMap<>();

        // Read words from the input file and count occurrences
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim().toLowerCase();  // Convert to lowercase to ensure case insensitivity
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("Error reading the input file: " + e.getMessage());
            return;
        }

        // Write the word counts to the output file
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error writing to the output file: " + e.getMessage());
        }

        System.out.println("Word counts have been written to " + outputFileName);
    }
}
