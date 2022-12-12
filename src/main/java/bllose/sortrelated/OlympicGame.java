package bllose.sortrelated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 2012伦敦奥运会即将到来，大家都非常关注奖牌榜的情况，现在我们假设奖牌榜的排名规则如下：
 * 1、首先gold medal数量多的排在前面；
 * 2、其次silver medal数量多的排在前面；
 * 3、然后bronze medal数量多的排在前面；
 * 4、若以上三个条件仍无法区分名次，则以国家名称的字典序排定。
 */
public class OlympicGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        List<Country> countries = new ArrayList<>();
        for(int i = 0; i < total; i ++){
            countries.add(new Country(in.next(), in.nextInt(), in.nextInt(), in.nextInt()));
        }
        in.close();
        Collections.sort(countries);
        countries.stream().forEach(x->System.out.println(x.name));
//        countries.stream().forEach(System.out::println);
    }

    static class Country implements Comparable<Country>{
        String name;
        int gold;
        int silver;
        int bronze;
        Country(String name, int gold, int silver, int bronze){
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
        public String showName(){
            return this.name;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold != o.gold) {
                return o.gold - this.gold;
            } else if (this.silver != o.silver) {
                return o.silver - this.silver;
            } else if (this.bronze != o.bronze) {
                return o.bronze - this.bronze;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }
}
