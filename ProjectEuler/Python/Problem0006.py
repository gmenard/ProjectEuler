'''
Problem 6 - Sum square difference

The sum of the squares of the first ten natural numbers is, 1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)^2 = 55^2 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.


Solution:
- Square of the sum: f(n) = n * (n + 1) / 2
- Sum of the squares: f(n) = (1/3 * n^3) + (1/2 * n^2) + (1/6 * n)

Result:  25164150.0
Execution time: 0.000059 seconds

@author: Guillaume MENARD
'''

from utils.Timer import timeExecution

n = 100

def main():
    square = (1 / 3 * n * n * n) + (1 / 2 * n * n) + (1 / 6 * n)
    sumN = n * (n + 1) / 2
    print('Result: ', (sumN * sumN) - square)


if __name__ == '__main__':
    timeExecution(main)
