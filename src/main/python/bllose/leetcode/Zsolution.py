
def solution(s:str, numRows:int) -> str:
    if numRows == 1:
        return s
    else:
        add = 2 * (numRows - 1)
        newStr = []
        for row in range(numRows):
            index = row
            addition = 0
            while index < len(s):
                newStr.append(s[index:index+1])
                addition += 1
                if row != 0 and row != numRows - 1:
                    middle = index + add - 2*row
                    if(middle < len(s)):
                        newStr.append(s[middle:middle+1])
                index += add
        return ''.join(newStr)


if __name__ == '__main__':
    print('PAHNAPLSIIGYIR = ' + str(solution("PAYPALISHIRING", 3)))
    print('PINALSIGYAHRPI = ' + str(solution("PAYPALISHIRING", 4)))
