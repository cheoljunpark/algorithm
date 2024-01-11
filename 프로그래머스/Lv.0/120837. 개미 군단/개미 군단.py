def solution(hp):
    n = 0
    
    for i in [5,3,1]:
        d, hp = divmod(hp,i)
        n += d
    
    return n