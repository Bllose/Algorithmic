'''
给定两个字符串 s 和 t ，每个字符串代表一个非负有理数，只有当它们表示相同的数字时才返回 true 。字符串中可以使用括号来表示有理数的重复部分。
有理数 最多可以用三个部分来表示：整数部分 、小数非重复部分 和小数重复部分 <(><)>。数字可以用以下三种方法之一来表示：
示例 1：

输入：s = "0.(52)", t = "0.5(25)"
输出：true
解释：因为 "0.(52)" 代表 0.52525252...，而 "0.5(25)" 代表 0.52525252525.....，则这两个字符串表示相同的数字。
示例 2：

输入：s = "0.1666(6)", t = "0.166(66)"
输出：true
示例 3：

输入：s = "0.9(9)", t = "1."
输出：true
解释："0.9(9)" 代表 0.999999999... 永远重复，等于 1 。[有关说明，请参阅此链接]
"1." 表示数字 1，其格式正确：(IntegerPart) = "1" 且 (NonRepeatingPart) = "" 。
提示：

每个部分仅由数字组成。
整数部分 不会以零开头。（零本身除外）
1 <= .length <= 4
0 <= .length <= 4
1 <= .length <= 4
'''
class EquiRational:
    def __init__(self, num1:str, num2:str):
        self.num1 = self.convert(num1)
        self.num2 = self.convert(num2)

    def convert(self, num:str):
        import re
        parts = re.split('[.()]', num)
        status = 0 # whole, sub, repeating
        ans = Fraction(0, 1)
        subLen = 0

        for cur in parts:
            status += 1
            if cur is None or len(cur) == 0:
                continue
            if status == 1:
                ans.add(Fraction(int(cur), 1))
            elif status == 2:
                subLen = len(cur)
                ans.add(Fraction(int(cur), 10 ** subLen))
            elif status == 3:
                denominator = (10 ** len(cur) - 1) * 10 ** subLen
                ans.add(Fraction(int(cur), denominator))
        return ans

    def compare(self) -> bool:
        return self.num1.d == self.num2.d and self.num1.n == self.num2.n


class Fraction:
    def __init__(self, numerator:int, denominator:int):
        gcd = self.greatest_common_divisor(numerator, denominator)
        self.n = int(numerator / gcd)
        self.d = int(denominator / gcd)

    def greatest_common_divisor(self, num1:int, num2:int) -> int:
        return num2 if num1 == 0 else self.greatest_common_divisor(num2%num1 , num1)

    def add(self, target) -> None:
        self.n = self.n * target.d + target.n * self.d
        self.d *= target.d
        gcd = self.greatest_common_divisor(self.n, self.d)
        self.n = int(self.n / gcd)
        self.d = int(self.d / gcd)


if __name__ == '__main__':
    # cur = Fraction(5, 25)
    # print(cur.n, cur.d)
    # addtion = Fraction(1, 10)
    # cur.add(addtion)
    # print(cur.n, cur.d)
    # print(EquiRational('0.(12)', '0.121(21)').compare())
    # print(EquiRational('0.(9)', '1').compare())
    print(EquiRational('0.9(9)', '1').compare())
