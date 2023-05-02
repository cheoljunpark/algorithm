def solution(sides):
    cnt = 0
    
    for i in range(1, max(sides)+1):
        if i + min(sides) > max(sides):
            cnt += 1
            
    for i in range(max(sides)+1, sum(sides)):
        if sum(sides) > i:
            cnt += 1
        
    return cnt
