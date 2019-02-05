import java.io.*;
import java.util.*;

public class ArrayListsAndStrings {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader("inputOutput/data.txt"  ));
        PrintWriter outFile = new PrintWriter("inputOutput/results.txt");

        HashSet<String> uniqueWords = new HashSet<>();
        ArrayList<String> allWords = new ArrayList<>();

        while (inFile.hasNext()) {
            String word = inFile.next();
            String[] words = word.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
            for (String s : words) {
                uniqueWords.add(s);
                allWords.add(s);
            }
        }
        uniqueWords.remove("");
        allWords.remove("");

        ArrayList<String> sortedUniqueWords= new ArrayList<>(uniqueWords);
        Collections.sort(sortedUniqueWords);

        outFile.println("Total number of words in text: " + allWords.size());
        outFile.println("Total number of unique words in text: " + sortedUniqueWords.size());

        for (String s : sortedUniqueWords) {
            int sCount = Collections.frequency(allWords, s);
            outFile.printf("%-30.30s  %-30.30s%n", s, sCount);
        }

        outFile.close();
    }
}