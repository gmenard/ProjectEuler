'''
Palindrome functions.

@author: Guillaume MENARD
'''


def isPalindrome(var):
    if var < 10: return True
    if var % 10 == 0: return False
    var = str(var)
    for i in range(0, int(len(var) / 2)):
        if(var[i] != var[len(var) - 1 - i]):
            return False
    return True

def isPalindrome2(var):
    if var < 10: return True
    if var % 10 == 0: return False
    num = var
    rev = 0
    while(num > 0):
        rev = rev * 10 + num % 10
        num = int(num / 10)
    if(rev == var): return True
    else: return False
