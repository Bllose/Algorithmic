package bllose.leetcode;

/**
 * 相等的非负有理数
 */
public class EquiRational {

    /**
     * <IntegerPart> 
     * 例： 0 ,12 和 123 
     * <IntegerPart><.><NonRepeatingPart>
     * 例： 0.5 , 1. , 2.12 和 123.0001
     * <IntegerPart><.><NonRepeatingPart><(><RepeatingPart><)> 
     * 例： 0.1(6) ， 1.(9)， 123.00(1212)
     * <p>
     * 每个部分仅由数字组成。
     * 整数部分 <IntegerPart> 不会以零开头。（零本身除外）
     * 1 <= <IntegerPart>.length <= 4
     * 0 <= <NonRepeatingPart>.length <= 4
     * 1 <= <RepeatingPart>.length <= 4
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isRationalEqualOne(String s, String t) {
        if (s.contains("(") && t.contains("(")) {
            String[] sArr = s.split("\\.");
            String[] tArr = t.split("\\.");
            if (!sArr[0].equals(tArr[0])) {
                return false;
            } else {
                String[] sDeci = sArr[1].replace(")", "").split("\\(");
                String[] tDeci = tArr[1].replace(")", "").split("\\(");

            }

        } else if (!s.contains("(") && !t.contains("(")) {
            if (Double.valueOf(s) - Double.valueOf(t) != 0) {
                return false;
            }
        } else if (s.contains("(") || t.contains("(")) {
            String bigOne;
            String smallOne;
            if (s.contains("(")) {
                bigOne = t;
                smallOne = s;
            } else {
                bigOne = s;
                smallOne = t;
            }
            String[] bigArr = bigOne.split("\\.");
            String[] smlArr = smallOne.split("\\.");

            if (bigArr.length > 1) {
                bigOne = bigArr[1];
                bigOne = bigOne.replaceAll("0", "");
                if (bigOne.length() > 0) {
                    return false;
                }
            }
            smallOne = smlArr[1];
            smallOne = smallOne.replace("(", "");
            smallOne = smallOne.replace(")", "");
            smallOne = smallOne.replaceAll("9", "");
            if (smallOne.length() > 0) {
                return false;
            }

            if (Integer.valueOf(bigArr[0]) - Integer.valueOf(smlArr[0]) != 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println("\"1314.1592\", \"1314.1592\" " + isRationalEqualOne("1314.1592", "1314.1592"));
//        System.out.println("\"49.324\", \"49.321\" " + isRationalEqualOne("49.324", "49.321"));
//        System.out.println("\"432.0001\", \"431.99(9)\" " + isRationalEqualOne("432.0001", "431.99(9)"));
//        System.out.println("\"432.0000\", \"431.99(9)\" " + isRationalEqualOne("432.0000", "431.99(9)"));
//        System.out.println("\"431.99(9)\", \"432.0000\" " + isRationalEqualOne("431.99(9)", "432.0000"));
//        System.out.println("\"432.\", \"431.99(9)\" " + isRationalEqualOne("432.", "431.99(9)"));
//        System.out.println("\"1.\", \"0.9999(9999)\" " + isRationalEqualOne("1.", "0.9999(9999)"));
//        System.out.println("\"1\", \"0.9999(9999)\" " + isRationalEqualOne("1", "0.9999(9999)"));

//        System.out.println("\"1314.1592\", \"1314.1592\" " + isRationalEqual("1314.1592", "1314.1592"));
//        System.out.println("\"49.324\", \"49.321\" " + isRationalEqual("49.324", "49.321"));
//        System.out.println("\"432.0001\", \"431.99(9)\" " + isRationalEqual("432.0001", "431.99(9)"));
//        System.out.println("\"432.0000\", \"431.99(9)\" " + isRationalEqual("432.0000", "431.99(9)"));
//        System.out.println("\"431.99(9)\", \"432.0000\" " + isRationalEqual("431.99(9)", "432.0000"));
//        System.out.println("\"432.\", \"431.99(9)\" " + isRationalEqual("432.", "431.99(9)"));
//        System.out.println("\"1.\", \"0.9999(9999)\" " + isRationalEqual("1.", "0.9999(9999)"));
//        System.out.println("\"1\", \"0.9999(9999)\" " + isRationalEqual("1", "0.9999(9999)"));
        System.out.println("\"0.(12)\", \"0.121(21)\" " + isRationalEqual("0.(12)", "0.121(21)"));
    }


    public static boolean isRationalEqual(String S, String T) {
        Fraction f1 = convert(S);
        Fraction f2 = convert(T);
        return f1.n == f2.n && f1.d == f2.d;
    }

    public static Fraction convert(String S) {
        int state = 0; //whole, decimal, repeating
        Fraction ans = new Fraction(0, 1);
        int decimal_size = 0;

        for (String part : S.split("[.()]")) {
            state++;
            if (part.isEmpty()) continue;
            long x = Long.valueOf(part);
            int sz = part.length();

            if (state == 1) { // whole
                ans.iadd(new Fraction(x, 1));
            } else if (state == 2) { // decimal
                ans.iadd(new Fraction(x, (long) Math.pow(10, sz)));
                decimal_size = sz;
            } else { // repeating
                long denom = (long) Math.pow(10, decimal_size);
                denom *= (long) (Math.pow(10, sz) - 1);
                ans.iadd(new Fraction(x, denom));
            }
        }
        return ans;
    }
}

class Fraction {
    long n, d;

    Fraction(long n, long d) {
        long g = gcd(n, d);
        this.n = n / g;
        this.d = d / g;
    }

    public void iadd(Fraction other) {
        long numerator = this.n * other.d + this.d * other.n;
        long denominator = this.d * other.d;
        long g = Fraction.gcd(numerator, denominator);
        this.n = numerator / g;
        this.d = denominator / g;
    }

    /**
     * Greatest Common Divisor
     */
    static long gcd(long x, long y) {
        return x != 0 ? gcd(y % x, x) : y;
    }
}
