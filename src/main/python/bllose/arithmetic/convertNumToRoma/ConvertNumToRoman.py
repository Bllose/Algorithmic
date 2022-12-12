'''
I: 1
V: 5
X: 10
L: 50
C: 100
D: 500
M: 1000
重点：
相同字母不能连续出现4次以上，包括4次。
所以 30: XXX; 40:XV

不能跨位数联动，比如 999 不能写成 IM， 只能写成 900 CM + 90 XC + 9 IX
'''
def intToRoman(num):
    nums = {4:['', 'M', 'MM', 'MMM', 'MMMM'],
            3:['', 'C', 'CC', 'CCC', 'CD', 'D', 'DC', 'DCC', 'DCCC', 'CM'],
            2:['', 'X', 'XX', 'XXX', 'XL', 'L', 'LX', 'LXX', 'LXXX', 'XC'],
            1:['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX']}

    roma = []
    roma.append(nums[4][int(num/1000%10)])
    roma.append(nums[3][int(num/100%10)])
    roma.append(nums[2][int(num/10%10)])
    roma.append(nums[1][int(num%10)])

    print(''.join(roma))

if __name__ == "__main__":
    intToRoman(3999)
