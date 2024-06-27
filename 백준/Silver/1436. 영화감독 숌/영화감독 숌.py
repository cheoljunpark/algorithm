n = int(input())

series = 0
number = 666

while True:
    if '666' in str(number):
        series += 1
    
    if series == n:
        break
    
    number += 1
    
print(number)    