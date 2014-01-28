'''
Problem 52 - Permuted multiples
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

Result:  142857
Execution time: 0.893035 seconds

@author: Guillaume MENARD
'''
from utils.Timer import timeExecution


def hasSameDigits(val1, val2):
    val1 = str(val1)
    val2 = str(val2)
    
    if(len(val1) != len(val2)):
        return False
    
    tab = [0] * 10
    
    for digit in val1:
        tab[int(digit)] += 1
    
    for digit in val2:
        tab[int(digit)] -= 1
    
    for i in range(len(tab)):
        if tab[i] != 0:
            return False
    return True  


def main():
    num = 0
    isFound = False
    while isFound == False:
        num += 1
        isFound = True
        for i in range (2, 6):
            if(hasSameDigits(num, i * num) == False):
                isFound = False
                break
    print('Result: ', num)


if __name__ == '__main__':
    timeExecution(main)
