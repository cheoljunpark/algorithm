def solution(s):
    l = s.split(' ')
    
    answer = 0
    
    for i in range(len(l)):
        if l[i] == 'Z':
            answer -= int(l[i-1])
            continue
        answer += int(l[i])
        
    return answer
