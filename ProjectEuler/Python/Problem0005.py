'''
Problem 5 - Smallest multiple

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

Result:  232792560
Execution time: 0.000623 seconds

@author: Guillaume MENARD
'''
from utils.Timer import timeExecution
from utils.PrimeFactor import getPrimeFactors

maxDivider = 20

def getPrimeMaxFactors(prime, primeFactorsList):
    maxFactors = 0
    for i in range(1, maxDivider + 1):
        for j in range(0, len(primeFactorsList[i])):
            isSamePrime = True
            if(primeFactorsList[i][j] != prime):
                isSamePrime = False
                break
        if(isSamePrime):
            length = len(primeFactorsList[i])
            if(maxFactors < length):
                maxFactors = length
    
    return maxFactors


def main():
    res = 1
    primeFactorsList = {}
    
    # for each divider, retrieve the list of their prime factors
    for diviser in range (1, maxDivider + 1):
        primeFactorsList[diviser] = getPrimeFactors(diviser)
    
    for diviser in range (1, maxDivider + 1):
        # if divider is already a prime factor
        if(len(getPrimeFactors(diviser)) == 1):
            # Retrieve the number of this prime divider needed to get any of the dividers and proceed calculation
            res *= diviser ** getPrimeMaxFactors(diviser, primeFactorsList)
        
    print('Result: ', res)


if __name__ == '__main__':
    timeExecution(main)
