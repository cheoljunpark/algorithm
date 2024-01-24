def solution(n):
    answer = 0
    
    for i in range(1, n+1):
        result = 0
        while result<n:
            result += i
            i += 1
        if result == n:
            answer += 1
            
    return answer