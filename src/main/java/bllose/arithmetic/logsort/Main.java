package bllose.arithmetic.logsort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static {
        try {
            System.setIn(new FileInputStream("src/main/java/bllose/arithmetic/logsort/source.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in .nextInt();
        in.nextLine();

        List<time> records = new ArrayList<>();
        for(int i = 0 ; i < times; i ++){
            records.add(new time(in.nextLine()));
        }

        Collections.sort(records, (time1, time2) -> {
            int compare = Integer.valueOf(time1.h) - Integer.valueOf(time2.h);
            if(compare != 0) return compare;
            compare = Integer.valueOf(time1.m) - Integer.valueOf(time2.m);
            if(compare != 0) return compare;
            compare = Integer.valueOf(time1.s) - Integer.valueOf(time2.s);
            if(compare != 0) return compare;
            compare = Integer.valueOf(time1.n) - Integer.valueOf(time2.n);
            return compare;
        });

        for(time currect: records){
            System.out.println(currect);
        }
    }

    static class time{
        String h;
        String m;
        String s;
        String n;
        time(String s){
            String[] times = s.split(":");
            h = times[0];
            m = times[1];
            String[] seconds = times[2].split("\\.");
            this.s = seconds[0];
            n = seconds[1];
        }

        @Override
        public String toString(){
            return h + ":" + m + ":" + s + "." + n;
        }
    }
}
