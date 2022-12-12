package bllose.arithmetic.checkin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static {
        System.out. println (System.getProperty ("user.dir"));
        // System.setIn(SwitchSubString.class.getResourceAsStream("D:\\workplace\\github\\bllose-algorithmic\\src\\main\\java\\bllose\\arithmetic\\switchsubstring\\Letters.txt"));
        try {
            System.setIn(new FileInputStream("src\\main\\java\\bllose\\arithmetic\\checkin\\source.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        in.nextLine(); // 空行去掉

        String regex = "absent";
        for(int i = 0 ; i < times; i ++){
            String checkIn = in.nextLine();
            Matcher m = Pattern.compile(regex).matcher(checkIn);
            int counter = 0; 
            while(m.find()) counter ++;
            if(counter > 1){
                System.out.print("false ");
                continue;
            }

            String[] each = checkIn.split(" ");
            int left = 0; 
            int right = 0;
            counter = 0;
            for(; right < each.length; right ++){
                String thisTime = each[right];
                if(thisTime.equals("absent")
                || thisTime.equals("late")
                || thisTime.equals("leaveearly")){
                    counter ++;
                }

                if(right > 6){
                    left ++;
                    if(each[left].equals("absent")
                    || each[left].equals("late")
                    || each[left].equals("leaveearly")){
                        counter --;
                    }
                }
                if(counter > 3){
                    System.out.print("false ");
                    break;
                }
            }
            if(counter < 4) System.out.print("true ");
        }
    }
}
