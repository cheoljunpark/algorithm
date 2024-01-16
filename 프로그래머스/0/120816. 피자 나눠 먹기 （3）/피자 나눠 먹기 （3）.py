def solution(slice, n):
    pizza = 0
    while True:
        if pizza * slice >= n:
            break
        pizza += 1
    return pizza