from main.python.bllose.sortrelated import KakaEatingBananas

def test_bananas_1():
    result = KakaEatingBananas.KakaEatingBananas([1,2,3], 2)
    assert result == -1

def test_bananas_2():
    assert 4 == KakaEatingBananas.KakaEatingBananas([3,6,7,11], 8)

def test_bananas_3():
    assert 30 == KakaEatingBananas.KakaEatingBananas([30,11,23,4,20], 5)

def test_bananas_4():
    assert 23 == KakaEatingBananas.KakaEatingBananas([30,11,23,4,20], 6)    