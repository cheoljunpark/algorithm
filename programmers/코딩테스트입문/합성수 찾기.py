def solution(n):
    def is_prime(number):
        for i in range(2,number):
            if number % i == 0:
                return 0
        return 1
    
    cnt = 0
    
    for i in range(1,n+1):
        if is_prime(i):
            continue
        cnt += 1
    
    return cnt
