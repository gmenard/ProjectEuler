'''
Problem 1 - Multiples of 3 and 5

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.

Result:  233168
Execution time: 0.0003493867950122377 seconds

@author: Guillaume MENARD
'''

from utils.Timer import timeExecution

def main():
    
    result = 0
    
    for number in range(1, 1000):
        
        if number % 3 == 0:
            result += number
            
        elif number % 5 == 0:
            result += number
            
    print('Result: ', result)


if __name__ == '__main__':
    timeExecution(main)
