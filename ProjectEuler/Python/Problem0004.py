'''
Problem 4 - Largest palindrome product

A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 * 99.
Find the largest palindrome made from the product of two 3-digit numbers.

Result:  906609
Execution time: 0.157951 seconds

@author: Guillaume MENARD
'''

from utils.Timer import timeExecution
from utils.Palindrome import isPalindrome


n = 3   # n-digit number

def main():
    # Define min/max of n-digit numbers
    mini = 1 * pow(10, n-1)
    maxi = 0   
    for i in range (0, n):
        maxi += 9 * pow(10, i)
    # Retrieve max palindrome value
    res = 0
    i = maxi + 1
    while(i > mini):
        j = i
        while(j > mini):
            num = i * j
            if(num > res and isPalindrome(num)):
                res = num
            j -= 1
        i -= 1
    print('Result: ', res)


if __name__ == '__main__':
    timeExecution(main)
