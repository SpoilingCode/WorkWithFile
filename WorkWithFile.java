
import java.util.ArrayList;
import java.util.Scanner;

public class WorkWithFile {


    public static void main(String[] args) {
        FileWorker fileWorker = new FileWorker();

        enterData(fileWorker);
        ArrayList<String> words = fileWorker.getWordsFromFile(fileWorker.getFileName());
        int countWords = fileWorker.calculateCountWords(words, fileWorker.getWordLength());
        fileWorker.printAmountWordsSpecifiedLength(countWords, fileWorker.getWordLength());
    }

    public static void enterData(FileWorker fileWorker){
        Scanner sc = new Scanner(System.in);
        String fileName;
        int wordLength;
        do {
            System.out.println("\nEnter file name: ");
            fileName = sc.nextLine();
            fileWorker.setFileName(fileName);
            if (!fileWorker.setFileName(fileName)) {
                System.out.println("File not found.Try again");
            }
        } while (!fileWorker.setFileName(fileName));

        do {
            System.out.println("\nEnter word length: ");
            wordLength = sc.nextInt();
            fileWorker.setWordLength(wordLength);
            if (!fileWorker.setWordLength(wordLength)) {
                System.out.println("Word length only of positive number");
            }
        } while (!fileWorker.setWordLength(wordLength));
    }


}
