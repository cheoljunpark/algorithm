def solution(n):
    answer = 0
    for i in range(n):
        if (i+1) % 2 == 0:
            answer += i+1
    return answer
