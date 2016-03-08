import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileWorker {
    private String fileName;
    private  int wordLength;

    public String getFileName() {
        return fileName;
    }

    public boolean setFileName(String fileName) {
        if(new File(fileName).exists()) {
            this.fileName = fileName;
            return true;
        }   return false;
    }

    public int getWordLength() {
        return wordLength;
    }

    public boolean setWordLength(int wordLength) {
        if(wordLength > 0) {
            this.wordLength = wordLength;
            return true;
        }   return false;
    }

    public ArrayList<String> getWordsFromFile(String fileName) {
        ArrayList<String> wordsArray = new ArrayList<String>();
        try (FileReader file = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split("[\" \"\n . , - + = [0-9] ]");
                for (int i = 0; i < array.length; i++) {
                    wordsArray.add(array[i]);
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return wordsArray;
    }



    public int calculateCountWords(ArrayList<String> wordsArray, int wordLength) {
        int count = 0;
        for (String word : wordsArray) {
            if (word.length() == wordLength) {
                count++;
            }
        }
        return count;
    }

    public void printAmountWordsSpecifiedLength(int countWords, int wordLength) {
        if (countWords == 0) {
            System.out.println("Words having a length " + wordLength + " is not found!");
        } else System.out.println("Amount words of length " + wordLength + " equal " + countWords);
    }
}
