'''
    Timer
'''

import time

def timeExecution(func):
    start_time = time.clock()
    func()
    end_time = time.clock()
    print('Execution time:', (end_time - start_time), 'seconds')