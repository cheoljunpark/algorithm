def solution(n):
    pizza = 0
    while True:
        if pizza * 7 >= n:
            break
        pizza += 1
    return pizza