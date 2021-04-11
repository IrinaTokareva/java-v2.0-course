import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task6 {

    public static void main(String[] args) {
        try {
            String text = readFile("./src/main/java/files/text.txt").toLowerCase();
            StringTokenizer tokenizer = new StringTokenizer(text, " \n\t-\".,?:;!()", false);
            Map<String, Integer> wordMap = getSortedWordMap(tokenizer);
            printStatistics(wordMap);
            List<String> mostRepeatedWords = getMostRepeatedWords(wordMap);
            System.out.printf("Most frequently repeated words are: %s. Repeat count: %d\n",
                    mostRepeatedWords.toString().replaceAll("\\[", "").replaceAll("]", ""),
                    wordMap.get(mostRepeatedWords.get(0)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName));
        StringBuilder text = new StringBuilder();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            text.append(s);
        }
        bufferedReader.close();
        return text.toString();
    }

    private static Map<String, Integer> getSortedWordMap(StringTokenizer tokenizer) {
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (wordMap.get(word) == null) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }
        return wordMap;
    }

    private static void printStatistics(Map<String, Integer> wordMap) {
        System.out.println("Word count statistics:");
        for (String key: wordMap.keySet()) {
            System.out.printf("%s: %d\n", key, wordMap.get(key));
        }
    }

    private static List<String> getMostRepeatedWords(Map<String, Integer> wordMap) {
        List<String> mostRepeatedWords = new ArrayList<String>();
        int maxRepeatCount = 0;
        for (String key: wordMap.keySet()) {
            int count = wordMap.get(key);
            if (count > maxRepeatCount) {
                maxRepeatCount = count;
                mostRepeatedWords.clear();
                mostRepeatedWords.add(key);
            } else if (count == maxRepeatCount) {
                mostRepeatedWords.add(key);
            }
        }
        return mostRepeatedWords;
    }
}
