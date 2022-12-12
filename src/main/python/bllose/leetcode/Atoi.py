def myAtoi(s:str) -> int:
    s = s.strip()

    isMinus = False
    if s.startswith('-'):
        isMinus = True
        s = s[1:]
    elif s.startswith('+'):
        s = s[1:]

    nums = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
    index = 0
    isHead = True
    number = 0
    while len(s) > 0:
        if isHead and s[index: index + 1] not in nums:
            return 0
        elif s[index: index + 1] not in nums:
            break
        if isHead and s[index: index + 1] == '0':
            s = s[1:]
        else:
            isHead = False
            number = number * 10 + int(s[index: index + 1])
            index += 1
            if index > 11:
                if isMinus:
                    return -2147483648
                else:
                    return 2147483647
            if index > len(s):
                break
    if not isMinus and number >= 2147483647:
        return 2147483647
    elif isMinus and number >= 2147483648:
        return -2147483648
    else:
        return number


if __name__ == '__main__':
    print('0 = ' + str(myAtoi('words and 987')))
    print('947 = ' + str(myAtoi('   000947')))
    print('4193 = ' + str(myAtoi('4193 with words')))
    print('42 = ' + str(myAtoi('42')))
    print('12345678 = ' + str(myAtoi(' 0000000000012345678')))
    print('-2147483648 = ' + str(myAtoi('-2147483648')))
    print('2147483647 = ' + str(myAtoi('2147483648')))
    print('1192820738 = ' + str(myAtoi(' 1192820738r2')))
    print('0 = ' + str(myAtoi('.1')))
    print('2147483647 = ' + str(myAtoi('20000000000000000000')))
