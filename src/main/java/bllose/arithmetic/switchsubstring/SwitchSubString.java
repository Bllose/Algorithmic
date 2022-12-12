package bllose.arithmetic.switchsubstring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SwitchSubString {
    static {
        System.out. println (System.getProperty ("user.dir"));
        // System.setIn(SwitchSubString.class.getResourceAsStream("D:\\workplace\\github\\bllose-algorithmic\\src\\main\\java\\bllose\\arithmetic\\switchsubstring\\Letters.txt"));
        try {
            System.setIn(new FileInputStream("src\\main\\java\\bllose\\arithmetic\\switchsubstring\\Letters.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给定一个字符串，只包含大写字母，求在包含同一字母的子串中，长度第 k 长的子串的长度，相同字母只取最长的那个子串。
     * AAAAHHHBBCDHHHH
     * 3
     * -> 2
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] letters = in.nextLine().toCharArray();
        int k = in.nextInt();

        Map<Character, Recorder> mark = new HashMap<>();
        char lastOne = '0';
        int counter = 0;
        for(char cur: letters){
            if(cur != lastOne){
                if(lastOne != '0'){
                    if(mark.containsKey(lastOne)){
                        if(mark.get(lastOne).counter < counter){
                            mark.get(lastOne).counter = counter;
                        } 
                    }else{
                        mark.put(lastOne, new Recorder(lastOne, counter));
                    }
                }
                lastOne = cur;
                counter = 1;
            }else{
                counter ++;
            }
        }
        if(mark.containsKey(lastOne)){
            if(mark.get(lastOne).counter < counter){
                mark.get(lastOne).counter = counter;
            } 
        }else{
            mark.put(lastOne, new Recorder(lastOne, counter));
        }
        List<Recorder> recorderList = mark.values().stream().collect(Collectors.toList());
        Collections.sort(recorderList, (o1, o2) -> o2.counter - o1.counter);
        System.out.println(recorderList.get(k-1).counter);
    }

    static class Recorder implements Comparator<Recorder>{
        char letter;
        int counter;
        Recorder(char letter){
            this.letter = letter;
            counter = 1;
        }
        Recorder(char letter, int counter){
            this.letter = letter;
            this.counter = counter;
        }
        @Override
        public int compare(Recorder o1, Recorder o2) {
            return o2.counter - o1.counter;
        }
    }
}
