package bllose.arithmetic.reverseSpecific;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static {
        try {
            System.setIn(new FileInputStream("src/main/java/bllose/arithmetic/reverseSpecific/source.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> wordList = Arrays.asList(in.nextLine().split(" "));
        int start = in.nextInt();
        int end = in.nextInt();

        List<String> reverseList = wordList.subList(start, end+1);
        Collections.reverse(reverseList);

        for(int i = 0 ; i < wordList.size(); i ++){
            if(i >= start && i <= end){
                System.out.print(reverseList.get(i-start) + " ");
                continue;
            }
            System.out.print(wordList.get(i) + " ");
        }
    }
}   
