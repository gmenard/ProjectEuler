'''
Problem 55 - Lychrel numbers

If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
Not all numbers produce palindromes so quickly. For example,
349 + 943 = 1292,
1292 + 2921 = 4213
4213 + 3124 = 7337
That is, 349 took three iterations to arrive at a palindrome.
Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome.
A number that never forms a palindrome through the reverse and add process is called a Lychrel number.
Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that
a number is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand,
it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with all the computing
power that exists, has managed so far to map it to a palindrome. In fact, 10677 is the first number to be
shown to require over fifty iterations before producing a palindrome:
4668731596684224866951378664 (53 iterations, 28-digits).
Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
How many Lychrel numbers are there below ten-thousand?


Result:  249
Execution time: 0.573379 seconds


@author: Guillaume MENARD
'''
from utils.Timer import timeExecution

limit = 10000
iterations = 50

def reverseNumber(val):
    toReverse = val
    reverse = 0
    while (toReverse > 0):
        digit = toReverse % 10
        reverse = reverse * 10 + digit
        toReverse = int(toReverse / 10)
    return reverse

def isLychrelNumber(val):
    n = 0
    while(n < iterations):
        val += reverseNumber(val)
        if(val == reverseNumber(val)):
            return False
        n += 1
        if(n == iterations):
            return True
            
def main():
    count = 0
    for val in range(1, limit):
        if(isLychrelNumber(val)):
            count += 1
    print('Result: ', count)


if __name__ == '__main__':
    timeExecution(main)
