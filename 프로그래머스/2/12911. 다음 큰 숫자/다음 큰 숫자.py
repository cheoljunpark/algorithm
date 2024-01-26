def solution(n):
    a = bin(n).count('1')
    while True:
        n+=1
        b= bin(n).count('1')
        if a==b:
            return n