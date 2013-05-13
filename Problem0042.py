'''
Problem 42 - Coded triangle numbers

The nth term of the sequence of triangle numbers is given by, tn = n(n+1)/2; so the first ten triangle numbers are:
1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?

Result:  162
Execution time: 0.006840 seconds

@author: Guillaume MENARD
'''
from utils.Timer import timeExecution
from math import sqrt

filepath = 'res/pb0042_words.txt'

def valueOfWord(word):
    val = 0
    base = ord('A') - 1
    for letter in word:
        val += ord(letter.upper()) - base
    return val

def isTriangleNumber(num):
    sol = -1 / 2 + sqrt(1 + (8 * num)) / 2
    if int(sol) == sol:
        return True
    else:
        return False

def main():
    count_triangle_words = 0
    file = open(filepath, 'r')
    for line in file:
        for word in line.replace("\"", "").split(","):
            value = valueOfWord(word)
            if(isTriangleNumber(value)):
                count_triangle_words += 1
    file.close()        
    print('Result: ', count_triangle_words)


if __name__ == '__main__':
    timeExecution(main)
