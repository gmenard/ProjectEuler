'''
Prime Factor functions.

@author: Guillaume MENARD
'''

def getPrimeFactors(number):
    origNumber = number
    
    listOfPrimeFactors = []
    for i in range(2, number):
        while(number % i == 0):
            listOfPrimeFactors.append(i)
            number /= i
    if(len(listOfPrimeFactors) == 0):
        listOfPrimeFactors.append(origNumber)

    return listOfPrimeFactors
        

