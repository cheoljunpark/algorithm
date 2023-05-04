def solution(n):
    def factorial(n):
        if n == 0:
            return 1
        return factorial(n-1)*n

    for i in range(1, 12):
        if factorial(i) > n:
            return i-1
