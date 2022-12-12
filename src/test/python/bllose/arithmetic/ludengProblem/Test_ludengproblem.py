from main.python.bllose.arithmetic.ludengProblem import ludeng

def test_ludeng_1():
    result = ludeng.ludengProblem('1 150 1 49', 4)
    assert result == 1
