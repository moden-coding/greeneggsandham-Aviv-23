/*
*Your mission is to write a small Java program that proves whether Green Eggs and Ham 
*really uses only 50 different words. You’ll start with two things: an empty Main class 
and a text file that contains the entire story. Your job is to read the file line by 
line and use appropriate skills to see count the number of words. How you do this is up to you!
*/

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        ArrayList<String> words = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        try (Scanner fileReader = new Scanner(Paths.get("src/greenEggsAndHam.txt"))) {
            while (fileReader.hasNextLine()) {
                String row = fileReader.nextLine();
                if (!row.isEmpty()) {
                    row = row.replace('!', ' ').trim();
                    row = row.replace('?', ' ').trim();
                    row = row.replace('.', ' ').trim();
                    row = row.replace(',', ' ').trim();
                    row = row.replace('-', ' ').trim();
String lower = row.toLowerCase();
                    list.add(lower);
                }

            }
        } catch (Exception e) {
            System.out.println("Reading the file greenEggsAndHam.txt failed.");
        }

        for (String sentence : list) {
            String[] rawWords = sentence.split(" ");
            for (String word : rawWords) {
                if (!words.contains(word)&&!word.equals("")) {
                    words.add(word);
                }
            }

        }
  System.out.println(words.size());

    }
}
