package bllose.arithmetic.privacyWord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static {
        try {
            System.setIn(new FileInputStream("src/main/java/bllose/arithmetic/privacyWord/source.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        String words = in.next();

        words = words.replaceAll("_+", "_");
        String[] wordArray = words.split("_");

        StringBuffer ans = new StringBuffer();
        if(wordArray[index].contains("\"")){
            int end = 0;
            for(int i = index + 1; i < wordArray.length; i ++){
                if(wordArray[i].contains("\"")){
                    end = i;
                    break;
                }
            }
            for(int i = 0 ; i < index; i ++){
                ans.append(wordArray[i]).append("_");
            }
            ans.append("******").append("_");

            for(int i = end; i < wordArray.length; i ++){
                ans.append(wordArray[i]).append("_");
            }
        }else{
            for(int i = 0 ; i < wordArray.length; i ++){
                if(i == index){
                    ans.append("******").append("_");
                    continue;
                }
                ans.append(wordArray[i]).append("_");
            }
        }

        System.out.println(ans.deleteCharAt(ans.length()-1).toString());
        
    }
}
