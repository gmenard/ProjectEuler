'''
Problem 36 - Double-base palindromes

The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
(Please note that the palindromic number, in either base, may not include leading zeros.)


Result:  872187
Execution time: 1.819563 seconds

@author: Guillaume MENARD
'''

from utils.Timer import timeExecution
from utils.Palindrome import isPalindrome

limit = 1000000

def decimalToBinary(decimal):
    binary = ""
    while(decimal != 0):
        binary += str(decimal % 2)
        decimal = int(decimal / 2)
    return binary

def main():
    res = 0
    for decimal in range(1, limit):
        if(isPalindrome(decimal) and isPalindrome(decimalToBinary(decimal))):
            res += decimal
    
    print('Result: ', res)


if __name__ == '__main__':
    timeExecution(main)
