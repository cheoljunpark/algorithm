def solution(s):
    char_list = sorted(list(set(s)))
    answer = ''
    
    for i in char_list:
        if s.count(i) == 1:
            answer += i
            
    return answer
