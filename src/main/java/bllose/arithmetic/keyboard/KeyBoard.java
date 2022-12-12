package bllose.arithmetic.keyboard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KeyBoard {
    static {
        try {
            System.setIn(new FileInputStream("src/main/java/bllose/arithmetic/keyboard/source.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int console = 0;
        int jqb = 0;
        boolean touch = false;
        for(String cur: input){
            if(cur.equals("ctrl-c")){
                jqb = console;
            }else if(cur.equals("ctrl-x")){
                jqb = console;
                console = 0;
            }else if(cur.equals("ctrl-a")){
                touch = true;
            }else if(cur.equals("ctrl-v")){
                if(touch){
                    console = jqb;
                    touch = false;
                }else{
                    console += jqb;
                }
            }else{
                if(touch){
                    console = 1;
                    touch = false;
                }else{
                    console ++;
                }
            }
        }
        System.out.println(console);
    }
}
